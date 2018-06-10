package top.yibobo.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Element;

import top.yibobo.util.handler.TypeHandlerFactory;

public class ElementHandler {
	//private List<Element> elements = new ArrayList<>();
	Map<String, Object> objectPool;
	
	public ElementHandler(Map<String, Object> objectPool) {
		this.objectPool = objectPool;
	}
	
	
	public void analysisElement(String filePath) {
		
		Element root = new DocumentHandler().getDocument(filePath).getRootElement();
		
		//遍历根节点得到所有的子节点
		for(Iterator<Element> rootIter = root.elementIterator();rootIter.hasNext();) {
			Element ele = rootIter.next();
			if(ele.getName().equals("bean"))
			beanHandler(ele);//将bean子节点传入beanHandler方法中
		}
	}
	
	
	private void beanHandler(Element bean){
		//获得该子节点的name和class属性值
		String key = bean.attributeValue("name");
		String classPath = bean.attributeValue("class");
		Object obj = null;//该class路径表示的对象
		try {
			obj = Class.forName(classPath).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//遍历子节点，获得所有的property属性节点
		for(Iterator<Element> beanIter = bean.elementIterator();beanIter.hasNext();) {
			Element property = beanIter.next();//指针下移，得到单个property属性节点
			String name = property.attributeValue("name");
			String value = property.attributeValue("value");
			String ref = property.attributeValue("ref");
			
			if(name!=null && value!=null)createBean(obj,name,value);
			else if(name!=null && ref!=null)createBean(obj,name,ref);
		}
		objectPool.put(key, obj);
	}
	
	/**
	 * 创建对象并且放入对象池中的方法
	 * @param obj 对象池中的值的引用
	 * @param name 对象中的属性名
	 * @param value 对象中的属性值
	 */
	private void createBean(Object obj,String name,String value){
		Class<?> cls = obj.getClass();
		try {
			Field field = cls.getDeclaredField(name);
			Class fieldType = field.getType();
			StringBuffer set = new StringBuffer("set");
			set.append(name.substring(0, 1).toUpperCase());
			set.append(name.substring(1));
			
			Method method = cls.getDeclaredMethod(set.toString(), fieldType);
			Object val = null;
			try {
				val = TypeHandlerFactory.creatTypeHandler(fieldType).typeHandler(fieldType, value);
			}catch (Exception e) {
				val = objectPool.get(value);
			}
			method.invoke(obj, val);
			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
}

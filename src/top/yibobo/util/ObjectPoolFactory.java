package top.yibobo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ObjectPoolFactory {
	// 这是一个对象池子，用来保存一个对象
	private Map<String, Object> objectPool = new HashMap<>();

	// 创建对象的方法，传入字符串(包名+类名)，根据该类名生成一个对象
	private Object createObject(String className)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> cls = Class.forName(className);
		return cls.newInstance();
	}

	
	public void initPool(String fileName) {
		ElementHandler e = new ElementHandler(objectPool);
		e.analysisElement(fileName);
	}
	
	
	
	
	
	/**
	 * 获取对象池中的一个对象，根据传入的名字来
	 * 
	 * @param name
	 * @return
	 */
	public Object getBean(String name) {
		return objectPool.get(name);
	}
	
	
	/**
	 * 向对象池中加入一个对象
	 * @param key
	 * @param value
	 */
	protected void setBean(String key,Object value) {
		objectPool.put(key, value);
	}
}

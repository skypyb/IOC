package top.yibobo.util;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class DocumentHandler {
	
	private Map<String,Document> documents = new HashMap<>();
	
	/**
	 * 通多传入的文件路径获取一个Document的方法
	 * @author pyb
	 * @param filePath
	 * @return
	 */
	public Document getDocument(String filePath) {
		Document doc = documents.get(filePath);
		if(doc == null) documents.put(filePath, readDocument(filePath));
		else return doc;
		
		return documents.get(filePath);
	}
	
	/**
	 * 用dom4j的解析器解析xml文档，保存成一个Document对象并返回
	 * @author pyb
	 * @param filePath
	 * @return
	 */
	private Document readDocument(String filePath) {
		
		SAXReader reader = new SAXReader();
		Document ducument = null;
		try {
			ducument = reader.read(filePath);
			
		} catch (DocumentException e) {
			System.out.println("解析xml出错了!请检查文档或路径，当前解析的路径为:"+filePath);
			e.printStackTrace();
		}
		return ducument;
	}
}

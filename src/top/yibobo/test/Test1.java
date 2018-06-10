package top.yibobo.test;

import top.yibobo.pojo.ClassInfo;
import top.yibobo.pojo.Student;
import top.yibobo.util.ElementHandler;
import top.yibobo.util.ObjectPoolFactory;

public class Test1 {
	public static void main(String[] args) {
		ObjectPoolFactory o = new ObjectPoolFactory();
		o.initPool("root.xml");
		
		
		ClassInfo classInfo = (ClassInfo) o.getBean("c");
		Student stu = (Student) o.getBean("s");
		
		System.out.println(classInfo);
		System.out.println(stu);
	}
}

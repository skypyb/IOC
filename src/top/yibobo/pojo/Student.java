package top.yibobo.pojo;

public class Student {
	private Integer stuId;
	private String name;
	private String sex;
	private ClassInfo classInfo;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Integer stuId, String name, String sex, ClassInfo classInfo) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.sex = sex;
		this.classInfo = classInfo;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public ClassInfo getClassInfo() {
		return classInfo;
	}
	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", name=" + name + ", sex=" + sex + ", classInfo=" + classInfo + "]";
	}
	
	
}

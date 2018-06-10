package top.yibobo.pojo;

public class ClassInfo {
	private Integer classInfoId;
	private String name;
	public ClassInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClassInfo(Integer classInfoId, String name) {
		super();
		this.classInfoId = classInfoId;
		this.name = name;
	}
	public Integer getClassInfoId() {
		return classInfoId;
	}
	public void setClassInfoId(Integer classInfoId) {
		this.classInfoId = classInfoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ClassInfo [classInfoId=" + classInfoId + ", name=" + name + "]";
	}
	
	
}

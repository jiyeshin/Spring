package vo;

public class PersonVo {
	private String name;
	private int age;
	private String phone;
	
	public PersonVo() {
		System.out.println("PersonVo의 생성자");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "PersonVo [name=" + name + ", age=" + age + ", phone=" + phone + "]";
	}
	
	
}

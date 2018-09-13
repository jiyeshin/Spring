package vo;

public class Sample {
	private int num;
	private String name;

	// DI하는 방법 중 생성자를 이용하는 방법은 아래처럼 생성자를 생성해야 가능함.
	public Sample(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	// 생성자를 만들면 기본으로 제공되는 디폴트 생성자가 사라짐.
	// 그래서 매개변수가 비어있는 생성자를 만들어야 함.
	// 왜냐하면 namespace p 를 사용하면 자동으로 비어있는 생성자를 new 하여 객체를 생성함.
	// 근데 위에 있는 생성자는 매개변수를 넣어야 하는 생성자임.
	// 그래서 비어있는 생성자도 만들어줘야 함.

	public Sample() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Sample [num=" + num + ", name=" + name + "]";
	}
}

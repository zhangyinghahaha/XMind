
class Person { // 定义Person类
	private String name; // 姓名
	private int age; // 年龄

	public Person(String name, int age) { // 通过构造方法赋值
		name = name;
		age = age;
	}

	public String getInfo() { // 取得信息的方法
		return "姓名：" + name + "，年龄：" + age;
	}
}


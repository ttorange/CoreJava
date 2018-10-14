package abstractClasses;
/*
 * 抽象类
 *   继承链中，上层更具有通用性
 *   抽象方法充当着站位的角色，子类可以定义全部抽象方法，这样它就不是抽象的了
 *   如果子类没有定义全部抽象方法，那么它依然是抽象类
 *   类不含抽象方法也可以定义为抽象类
 *   抽象类不能被实例化（比如new person("Swift")将会报错
 */
public abstract class Person {
	public abstract String getDescription();//抽象方法
	private String name;
	public Person(String n) {
		name=n;
	}
	public String getName() {
		return name;
	}

}

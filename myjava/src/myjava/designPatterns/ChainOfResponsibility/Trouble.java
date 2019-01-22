package myjava.designPatterns.ChainOfResponsibility;

/**
 * Created by Administrator on 2018/8/20.
 *
 * 要处理的问题
 */
public class Trouble {

	private Integer number;
	
	public Trouble(Integer number) {
		this.setNumber(number);
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}

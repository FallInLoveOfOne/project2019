package myjava.designPatterns.ChainOfResponsibility;

/**
 * Created by Administrator on 2018/8/20.
 *
 * 只处理小于定义的数字
 */
public class LessSupport extends Support {

	private Integer lessNumber;

	public LessSupport(String name, Integer lessNumber) {
		super(name);
		this.lessNumber = lessNumber;
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		return trouble.getNumber() < this.lessNumber;
	}
}

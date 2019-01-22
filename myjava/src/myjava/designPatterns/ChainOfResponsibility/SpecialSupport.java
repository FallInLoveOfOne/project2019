package myjava.designPatterns.ChainOfResponsibility;

/**
 * Created by Administrator on 2018/8/20.
 *
 * 只能处理特定的数字
 */
public class SpecialSupport extends Support {

	/**
	 * 指定只能处理的数字
	 */
	private Integer specialNumber;

	public SpecialSupport(String name, Integer specialNumber) {
		super(name);
		this.specialNumber = specialNumber;
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		return trouble.getNumber().equals(this.specialNumber);
	}
}

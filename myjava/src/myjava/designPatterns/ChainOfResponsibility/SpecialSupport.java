package myjava.designPatterns.ChainOfResponsibility;

/**
 * Created by Administrator on 2018/8/20.
 *
 * ֻ�ܴ����ض�������
 */
public class SpecialSupport extends Support {

	/**
	 * ָ��ֻ�ܴ��������
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

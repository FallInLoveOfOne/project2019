package myjava.designPatterns.ChainOfResponsibility;

/**
 * Created by Administrator on 2018/8/20.
 *
 * ������������
 */
public abstract class Support {

	/**
	 * ������������
	 */
	private String name;

	/**
	 * ����������һ���ڵ�
	 */
	private Support nextSupport;

	public Support(String name) {
		this.name = name;
		System.out.println(this.name);
	}

	/**
	 * ִ������������һ���ڵ�
	 */
	public Support setNextSupport(Support nextSupport) {
		this.nextSupport = nextSupport;
		return nextSupport;
	}

	/**
	 * �������ĳ��󷽷�,������ʵ��
	 */
	protected abstract boolean resolve(Trouble trouble);

	/**
	 * �������Ĳ���
	 */
	public final void support(Trouble trouble) {
		if (resolve(trouble)) {
			haveDone(trouble);
		} else if (this.nextSupport != null) {
			this.nextSupport.support(trouble);
		} else {
			failDone(trouble);
		}
	}

	/**
	 * ��������ִ�еķ���
	 */
	protected void haveDone(Trouble trouble) {
		System.out.println(String.format("%s have been resolved by %s .",
				trouble, this));
	}

	/**
	 * δ�ܽ������ִ�еķ���
	 */
	protected void failDone(Trouble trouble) {
		System.out.println(String.format("%s can't be resolved .", trouble));
	}
}

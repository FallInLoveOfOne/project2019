package myjava.designPatterns.ChainOfResponsibility;

/**
 * Created by Administrator on 2018/8/20.
 *
 * 责任链抽象类
 */
public abstract class Support {

	/**
	 * 责任链的名字
	 */
	private String name;

	/**
	 * 责任链的下一个节点
	 */
	private Support nextSupport;

	public Support(String name) {
		this.name = name;
		System.out.println(this.name);
	}

	/**
	 * 执行责任链的下一个节点
	 */
	public Support setNextSupport(Support nextSupport) {
		this.nextSupport = nextSupport;
		return nextSupport;
	}

	/**
	 * 解决问题的抽象方法,供子类实现
	 */
	protected abstract boolean resolve(Trouble trouble);

	/**
	 * 解决问题的步骤
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
	 * 解决问题后执行的方法
	 */
	protected void haveDone(Trouble trouble) {
		System.out.println(String.format("%s have been resolved by %s .",
				trouble, this));
	}

	/**
	 * 未能解决问题执行的方法
	 */
	protected void failDone(Trouble trouble) {
		System.out.println(String.format("%s can't be resolved .", trouble));
	}
}

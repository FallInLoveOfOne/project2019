package myjava.designPatterns.ChainOfResponsibility;

/**
 * Created by Administrator on 2018/8/20.
 *
 * ����ʲôҲ������
 */

public class NoSupport extends Support {

	public NoSupport(String name) {
		super(name);
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		return false;
	}
}
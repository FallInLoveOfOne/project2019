package myjava.designPatterns.ChainOfResponsibility;

/**
 * Created by Administrator on 2018/8/20.
 * <p>
 * ´¦ÀíÆæÊı
 */
public class OddSupport extends Support {

	public OddSupport(String name) {
		super(name);
	}

	@Override
	protected boolean resolve(Trouble trouble) {
		return trouble.getNumber() % 2 == 0;
	}
}

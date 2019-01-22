package myjava.thisEs;

public class TestEscapeDeal {
	private String name;
	private Thread thread;

	public TestEscapeDeal(String name) throws InterruptedException {

		thread = new Thread(new EscapeRunnable());
		Thread.sleep(1); // 增加构造函数的负责度，加长name初始化时间，否则在测试过程中，并没有发生其为null的情况
		this.name = name;

	}

	public void init() {
		thread.start();
	}

	private class EscapeRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println(name);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// 由于已经将构造函数初始化完成，其后调用的方法，均可以正常执行，与预期无差异。
		new TestEscapeDeal("woniu").init();
	}
}
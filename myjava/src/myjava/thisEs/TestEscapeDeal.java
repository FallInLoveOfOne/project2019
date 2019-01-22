package myjava.thisEs;

public class TestEscapeDeal {
	private String name;
	private Thread thread;

	public TestEscapeDeal(String name) throws InterruptedException {

		thread = new Thread(new EscapeRunnable());
		Thread.sleep(1); // ���ӹ��캯���ĸ���ȣ��ӳ�name��ʼ��ʱ�䣬�����ڲ��Թ����У���û�з�����Ϊnull�����
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
		// �����Ѿ������캯����ʼ����ɣ������õķ���������������ִ�У���Ԥ���޲��졣
		new TestEscapeDeal("woniu").init();
	}
}
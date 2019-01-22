package myjava.thisEs;


public class TestEscape {
	private String name;
	public static String number;
	static{
		System.out.println("currentThread:"+Thread.currentThread().getName());
		number = "haha";
	}

	public TestEscape(String name) throws InterruptedException {

		new Thread(new EscapeRunnable()).start();
//		Thread.sleep(1); // ���ӹ��캯���ĸ���ȣ��ӳ�name��ʼ��ʱ�䣬�����ڲ��Թ����У���û�з�����Ϊnull�����
		this.name = name;

	}

	private class EscapeRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println("currentThread:"+Thread.currentThread().getName());
			System.out.println(name);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("currentThread:"+Thread.currentThread().getName());
		new TestEscape("woniu");
	}
}
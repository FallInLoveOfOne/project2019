package myjava.threadPool;

import java.util.Vector;

public class Test {

	private static Vector<Integer> vector = new Vector<Integer>();

	public static void main(String[] args) {
		while (true) {
			for (int i = 0; i < 10; i++) {
				vector.add(i);
			}
			Thread removeThread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < vector.size(); i++) {
						vector.remove(i);
					}
				}
			});
			Thread printThread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < vector.size(); i++) {
						System.out.println((vector.get(i)));
					}
				}
			});
			removeThread.start();
			printThread.start();
			// ��Ҫͬʱ����������̣߳�����ᵼ�²���ϵͳ����
			while (Thread.activeCount() > 5)
				;
		}
	}

}
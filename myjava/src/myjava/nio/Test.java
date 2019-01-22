package myjava.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class Test {

	static void readNIO() {
		String pathname = "C:\\Users\\adew\\Desktop\\jd-gui.cfg";
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(new File(pathname));
			FileChannel channel = fin.getChannel();

			int capacity = 100;// �ֽ�
			ByteBuffer bf = ByteBuffer.allocate(capacity);
			System.out.println("�����ǣ�" + bf.limit() + "�����ǣ�" + bf.capacity()
					+ "λ���ǣ�" + bf.position());
			int length = -1;

			while ((length = channel.read(bf)) != -1) {

				/*
				 * ע�⣬��ȡ�󣬽�λ����Ϊ0����limit��Ϊ����, �Ա��´ζ��뵽�ֽڻ����У���0��ʼ�洢
				 */
				bf.clear();
				byte[] bytes = bf.array();
				System.out.write(bytes, 0, length);
				System.out.println();

				System.out.println("�����ǣ�" + bf.limit() + "�����ǣ�" + bf.capacity()
						+ "λ���ǣ�" + bf.position());

			}

			channel.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static void writeNIO() {
		String filename = "out.txt";
		FileOutputStream fos = null;
		try {

			fos = new FileOutputStream(new File(filename));
			FileChannel channel = fos.getChannel();
			ByteBuffer src = Charset.forName("utf8").encode("���������������");
			// �ֽڻ����������limit���������ݳ��ȱ仯�����ǹ̶������
			System.out.println("��ʼ��������limit��" + src.capacity() + ","
					+ src.limit());
			int length = 0;

			while ((length = channel.write(src)) != 0) {
				/*
				 * ע�⣬���ﲻ��Ҫclear���������е�����д�뵽ͨ���к� �ڶ��ν�����һ�ε�˳�����¶�
				 */
				System.out.println("д�볤��:" + length);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static void testReadAndWriteNIO() {
		String pathname = "C:\\Users\\adew\\Desktop\\test.txt";
		FileInputStream fin = null;

		String filename = "test-out.txt";
		FileOutputStream fos = null;
		try {
			fin = new FileInputStream(new File(pathname));
			FileChannel channel = fin.getChannel();

			int capacity = 100;// �ֽ�
			ByteBuffer bf = ByteBuffer.allocate(capacity);
			System.out.println("�����ǣ�" + bf.limit() + "�����ǣ�" + bf.capacity()
					+ "λ���ǣ�" + bf.position());
			int length = -1;

			fos = new FileOutputStream(new File(filename));
			FileChannel outchannel = fos.getChannel();

			while ((length = channel.read(bf)) != -1) {

				// ����ǰλ����Ϊlimit��Ȼ�����õ�ǰλ��Ϊ0��Ҳ���Ǵ�0��limit��飬��д�뵽ͬ����
				bf.flip();

				int outlength = 0;
				while ((outlength = outchannel.write(bf)) != 0) {
					System.out.println("����" + length + "д," + outlength);
				}

				// ����ǰλ����Ϊ0��Ȼ������limitΪ������Ҳ���Ǵ�0��limit����������飬
				// ���������ã�ͨ����ȡ�����ݴ洢��
				// 0��limit���
				bf.clear();

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		testReadAndWriteNIO();
	}

}

package myjava.exp;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * �쳣����
 * @author yxm
 *
 */
public class Test {

	// ��ȡ�����2����������
	private static List<Integer> getInputNumbers() {
		List<Integer> nums = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		try {
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			nums.add(new Integer(num1));
			nums.add(new Integer(num2));
		} catch (InputMismatchException immExp) {
			throw immExp;
		} finally {
			scan.close();
		}
		return nums;
	}

	// ִ�мӷ�����
	private static int add() throws Exception {
		int result;
		try {
			List<Integer> nums = getInputNumbers();
			result = nums.get(0) + nums.get(1);
		} catch (InputMismatchException immExp) {
			throw new Exception("����ʧ��", immExp); // ///////////////////////////����:��һ���쳣����Ϊ���������µ��쳣����
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("������2������");
		int result;
		try {
			result = add();
			System.out.println("���:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

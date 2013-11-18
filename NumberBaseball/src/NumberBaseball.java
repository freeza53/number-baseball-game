import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class NumberBaseball {

	private static final Logger logger = Logger.getLogger(NumberBaseball.class);

	public static void main(String[] args) {
		int[] a = getNumbersFromUser();
		System.out.println(a[0] + "-" + a[1] + "-" + a[2]);
		// TODO Auto-generated method stub

		logger.debug("���� �߱� ���� ����!");

		int[] showNum = new int[3]; // ��ǻ�Ϳ��� ���� ���� 3��
		int[] inputNum = new int[3]; // �÷��̾ ���� ���� 3��

		// ���� 3 �����
		Random rNum = new Random();

		showNum[0] = rNum.nextInt(10);
		showNum[1] = rNum.nextInt(10);
		showNum[2] = rNum.nextInt(10);

		if (showNum[0] == showNum[1]) {
			showNum[1] = rNum.nextInt(10);
		}

		if (showNum[0] == showNum[2]) {
			showNum[2] = rNum.nextInt(10);
		} else if (showNum[1] == showNum[2]) {
			showNum[2] = rNum.nextInt(10);
		}

		logger.debug("���� 3���� �����ϼ���!");

		for (int i = 0; i < inputNum.length; i++) {
			inputNum[i] = rNum.nextInt(10);
		}

		// �ߺ�üũ �ؾ���!!

		logger.debug("�Է��� �� : " + Arrays.toString(inputNum));
	}

	private static int[] getNumbersFromUser() {
		final int[] result = new int[3];
		int aNumber = 0;
		Scanner a = null;
		try {
			a = new Scanner(System.in);
			do {
				System.out.println("���ڸ� �Է��ϼ���.");
				aNumber = a.nextInt();
			} while (aNumber < 99 || aNumber > 999);
		} finally {
			a.close();
		}
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = aNumber % 10;
			aNumber = aNumber / 10;
		}
		return result;
	}

}

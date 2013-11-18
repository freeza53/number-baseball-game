import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class NumberBaseball {

	private static final Logger logger = Logger.getLogger(NumberBaseball.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		logger.debug("���� �߱� ���� ����!");

		final List<Integer> showNum = generateNumber(3, 10);

		// ���� 3 �����
		System.out.println("���� ����: " + showNum);

		// ���� ��

		int inning = playResult(showNum);

	}

	private static List<Integer> generateNumber(int count, int range) {
		final List<Integer> result = new ArrayList<Integer>(count);
		final Random rNum = new Random();
		for (int i = 0; i < count; i++) {
			setANumber(result, rNum, range);
		}

		return result;
	}

	private static void setANumber(List<Integer> result, Random rNum, int LIMIT) {
		int aNum = 0;
		do {
			aNum = rNum.nextInt(LIMIT);
		} while (result.contains(aNum));
		result.add(aNum);
	}

	/*
	 * ����ڰ� �ѹ� �Է��ؼ� ����� ����ϴ� �� ������ ó��.
	 */
	private static int playResult(List<Integer> showNum) {

		// �÷��̾� ���� �Է�

		int inning = 1;
		for (int n = 0; n < 10; n++, inning++) {
			int sChk = 0;
			int bChk = 0;
			List<Integer> aNumber = getNumbersFromUser(); // �÷��̾ �Է��� ���� 3��
			System.out.println(aNumber);
			for (int i = 0; i < showNum.size(); i++) {
				for (int j = 0; j < aNumber.size(); j++) {
					if (showNum.get(i) == aNumber.get(j) && i == j) {
						// System.out.println("Strike!!!");
						sChk = sChk + 1;
					} else if (showNum.get(i) == aNumber.get(j) && i != j) {
						// System.out.println("Ball!!!");
						bChk = bChk + 1;
					} else {
						// System.out.println("Out!!!");
					}
				}
			}
			System.out.println("==== " + inning
					+ "ȸ ���! ===========================");
			System.out.println("��Ʈ����ũ: " + sChk + " ��: " + bChk + " �ƿ�: "
					+ (3 - sChk - bChk));
			if (sChk >= 3) {
				break;
			}

		}
		return inning;
	}

	final static Scanner a = new Scanner(System.in);

	private static List<Integer> getNumbersFromUser() {
		final List<Integer> result = new ArrayList<Integer>(3);
		int aNumber = 0;
		do {
			System.out.println("���ڸ� �Է��ϼ���.");
			aNumber = a.nextInt();
		} while (aNumber < 12 || aNumber > 999);

		for (int i = 0; i < 3; i++) {
			result.add(0,aNumber % 10);
			aNumber = aNumber / 10;
		}
		return result;
	}

}

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class NumberBaseball {

	private static final Logger logger = Logger.getLogger(NumberBaseball.class);

	public static void main(String[] args) {

		logger.debug("���� �߱� ���� ����!");
		final List<Integer> showNum = generateNumber(3, 10);
		int inning = gamePlay(showNum, 12);
		logger.info("win!! at " + inning + " innings");
		logger.info("game finished.");
		
	}

	/**
	 * ���� ���� ����.
	 */
	private static List<Integer> generateNumber(int count, int range) {
		final List<Integer> result = new ArrayList<Integer>(count);
		final Random rNum = new Random();
		for (int i = 0; i < count; i++) {
			result.add(getAnUniqueRandomNumber(result, rNum, range));
		}

		return result;
	}

	/**
	 * �ߺ����� �ʴ� ���ڸ� �����ϰ� ����.
	 */
	private static int getAnUniqueRandomNumber(List<Integer> showNum,
			Random rNum, int LIMIT) {
		int result = 0;
		do {
			result = rNum.nextInt(LIMIT);
		} while (showNum.contains(result));
		return result;
	}

	/**
	 * ���� �÷���
	 */
	private static int gamePlay(List<Integer> showNum, int limitInning) {
		int inning = 1;

		for (; inning <= limitInning; inning++) {
			boolean isFinish = playInning(showNum, inning);
			if (isFinish) {
				break;
			}
		}
		return inning;
	}

	/**
	 * �̴׿����� ó�� ����ڿ��� ���� �޾Ƽ� �� ī��Ʈ�� ������. �� ī��Ʈ�� ��� ������ ���߸� ����
	 */
	private static final boolean playInning(List<Integer> showNum, int inning) {
		boolean result = false;
		int sChk = 0;
		int bChk = 0;
		List<Integer> userInputtedNumber = getNumbersFromUser(); // �÷��̾ �Է��� ����
																	// 3��
		for (int i = 0; i < userInputtedNumber.size(); i++) {
			int aNumber = userInputtedNumber.get(i);
			sChk = (isStrike(aNumber, i, showNum)) ? ++sChk : sChk;
			bChk = (isBall(aNumber, i, showNum)) ? ++bChk : bChk;
		}
		result = sChk >= 3;
		logger.info("[" + inning + "ȸ] :: ��Ʈ����ũ: " + sChk + ",  ��: "
				+ bChk + "===================");
		return result;
	}

	/**
	 * �� ���� �Ǵ�
	 */
	final static boolean isBall(int aNumber, int index, List<Integer> showNum) {
		boolean result = false;
		if (showNum == null) {
			return result;
		}
		if (showNum.size() == 0) {
			return result;
		}

		if (showNum.contains(aNumber)) {
			if (aNumber != showNum.get(index)) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * ��Ʈ����ũ ���� �Ǵ�
	 */
	final static boolean isStrike(int aNumber, int index, List<Integer> showNum) {
		boolean result = false;
		if (showNum == null) {
			return result;
		}
		if (showNum.size() == 0) {
			return result;
		}
		result = aNumber == showNum.get(index);
		return result;
	}

	final static Scanner a = new Scanner(System.in);

	/**
	 * ����ڿ��Լ� ���ڸ� �޴� ó��.
	 */
	private static List<Integer> getNumbersFromUser() {
		final List<Integer> result = new ArrayList<Integer>(3);
		int aNumber = 0;
		do {
			logger.info("���ڸ� �Է��ϼ���.");
			aNumber = a.nextInt();
		} while (aNumber < 12 || aNumber > 999);

		for (int i = 0; i < 3; i++) {
			result.add(0, aNumber % 10);
			aNumber = aNumber / 10;
		}
		return result;
	}

}

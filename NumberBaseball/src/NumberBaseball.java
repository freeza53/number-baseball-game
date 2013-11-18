import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class NumberBaseball {

	private static final Logger logger = Logger.getLogger(NumberBaseball.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		logger.debug("���� �߱� ���� ����!");

		int[] showNum = new int[3]; // ��ǻ�Ϳ��� ���� ���� 3��
		int[] inputNum = new int[3]; // �÷��̾ �Է��� ���� 3��

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
		System.out.println("���� ����: " + showNum[0] + "-" + showNum[1]  + "-" + showNum[2]);
		

		// �÷��̾� ���� �Է�
		int[] a = getNumbersFromUser();
		System.out.println(a[0] + "-" + a[1] + "-" + a[2]);
		
		//���� ��
		int sChk = 0;
		int bChk = 0;
		
		for(int i=0;i<showNum.length;i++){
			for(int j=0;j<a.length;j++){
				if(showNum[i] == a[j] && i == j){
					//System.out.println("Strike!!!");
					sChk = sChk + 1;
				}else if(showNum[i] == a[j] && i != j){
					//System.out.println("Ball!!!");
					bChk = bChk + 1;
				}else{
					//System.out.println("Out!!!");
				}
			}
		}
		System.out.println("==== Result ===========================");
		System.out.println("��Ʈ����ũ: " + sChk + " ��: "+ bChk + " �ƿ�: " + (3-sChk-bChk));
		
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
			} while (aNumber < 12 || aNumber > 999);
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

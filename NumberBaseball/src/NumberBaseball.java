import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class NumberBaseball {

	private static final Logger logger = Logger.getLogger(NumberBaseball.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		logger.debug("숫자 야구 게임 시작!");

		int[] showNum = new int[3]; // 컴퓨터에서 뽑은 정수 3개
		int[] inputNum = new int[3]; // 플레이어가 입력한 정수 3개

		// 정수 3 만들기
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
		System.out.println("맞출 숫자: " + showNum[0] + "-" + showNum[1]  + "-" + showNum[2]);
		

		// 플레이어 숫자 입력
		int[] a = getNumbersFromUser();
		System.out.println(a[0] + "-" + a[1] + "-" + a[2]);
		
		//숫자 비교
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
		System.out.println("스트라이크: " + sChk + " 볼: "+ bChk + " 아웃: " + (3-sChk-bChk));
		
	}

	private static int[] getNumbersFromUser() {
		final int[] result = new int[3];
		int aNumber = 0;
		Scanner a = null;
		try {
			a = new Scanner(System.in);
			do {
				System.out.println("숫자를 입력하세요.");
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

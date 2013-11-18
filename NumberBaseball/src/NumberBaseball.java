import java.util.Arrays;
import java.util.Random;

import org.apache.log4j.Logger;


public class NumberBaseball {
	
	private static final Logger logger = Logger.getLogger(NumberBaseball.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		logger.debug("숫자 야구 게임 시작!");
		
		
		int[] showNum = new int[3]; //컴퓨터에서 뽑은 정수 3개 
		int[] inputNum = new int[3]; //플레이어가 뽑은 정수 3개 
		
		//정수 3 만들기 
		Random rNum = new Random();
		
		showNum[0] = rNum.nextInt(10);
		showNum[1] = rNum.nextInt(10);
		showNum[2] = rNum.nextInt(10);
	
		if(showNum[0] == showNum[1]){
			showNum[1] = rNum.nextInt(10);
		}
		
		if(showNum[0] == showNum[2]){
			showNum[2] = rNum.nextInt(10);
		}else if(showNum[1] == showNum[2]){
			showNum[2] = rNum.nextInt(10);
		}

		logger.debug("숫자 3개를 선택하세요!");
		
		for(int i=0;i<inputNum.length;i++){
			inputNum[i] = rNum.nextInt(10);
		}
		
		//중복체크 해야함!!  
		
		
		logger.debug("입력한 수 : " +Arrays.toString(inputNum));
	}

}

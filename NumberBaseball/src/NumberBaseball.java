import java.util.Arrays;
import java.util.Random;

import org.apache.log4j.Logger;


public class NumberBaseball {
	
	private static final Logger logger = Logger.getLogger(NumberBaseball.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		logger.debug("���� �߱� ���� ����!");
		
		
		int[] showNum = new int[3]; //��ǻ�Ϳ��� ���� ���� 3�� 
		int[] inputNum = new int[3]; //�÷��̾ ���� ���� 3�� 
		
		//���� 3 ����� 
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

		logger.debug("���� 3���� �����ϼ���!");
		
		for(int i=0;i<inputNum.length;i++){
			inputNum[i] = rNum.nextInt(10);
		}
		
		//�ߺ�üũ �ؾ���!!  
		
		
		logger.debug("�Է��� �� : " +Arrays.toString(inputNum));
	}

}

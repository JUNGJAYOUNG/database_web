package codingTest;
import java.util.*;

public class NumberCardGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int row=sc.nextInt();
		int col=sc.nextInt();
		int result = 0;
		
		//한줄씩 입력받아 확인하기
		for(int i=0 ; i<row ; i++) {
			//현재 중에서 '가장 작은 수' 찾기
			int min = 10001;
			for(int j=0 ; j<col ; j++) {
				int x = sc.nextInt();
				min = Math.min(min, x);
			}
			//'가장 작은 수'들 중에서 가장 큰 수 찾기
			result = Math.max(result, min);
		}
		System.out.println(result);
	}

}

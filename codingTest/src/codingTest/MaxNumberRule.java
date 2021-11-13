package codingTest;
import java.util.*;

public class MaxNumberRule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//N, M, K를 공백을 기준으로 구분하여 입력받기
		int n = sc.nextInt();	//배열의 크기
		int m = sc.nextInt();	//숫자가 더해지는 횟수
		int k = sc.nextInt();	//초과해서 연속으로 더할 수 없는 제한 횟수
		
		//N개의 수를 공백을 기준으로 구분하여 입력받기
		int []arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr); //.sort() 배열정렬
		int first = arr[n-1];	//가장 큰수
		int second = arr[n-2];	//두번째로 큰수
		
		/*단순하게 푸는 방법
		//가장 큰수를 k번 더하고 두번째로 큰 수를 한번 더하는 연산을 반복
		int result = 0;
		while(true) {
			for(int i=0;i<k;i++) {	//가장큰수 k번 더하기
				if(m==0)	//전체 더하기 횟수 0이면 탈출
					break;
				result += first; //가장큰수 누적
				m-=1;	//더할때마다 더하기 횟수 차감
			}
			if(m==0)	//전체 더하기 횟수 0이면 while문 아예 탈출
				break;
			result += second;	//두번째로 큰 수 한번 더하기
			m-=1;
		}
		*/
		
		//수학적으로 푸는 방법
		int cnt = (m/(k+1))*k;	//가장 큰 수가 더해지는 횟수 계산
		cnt += m % (k+1);	//k+1로 딱 떨어지지 않을경우 그만큼 가장 큰수를 더 더하기
		
		int result = 0;
		result += cnt * first; //가장 큰 수 더하기
		result += (m - cnt) * second;//가장 큰 수 다 더하고 남은 횟수만큼 두번째로 큰 수 더하기
		
		System.out.println(result);
	}

}

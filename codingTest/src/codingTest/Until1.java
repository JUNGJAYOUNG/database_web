package codingTest;
import java.util.*;

public class Until1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int cnt=0;
		
		//n이 k이상이라면 k로 계속 나누기
		while(n>=k) {
			//n이 k로 나눠떨어지지 않으면 1씩 빼기
			while(n%k!=0) {
				n-=1;
				cnt++;
			}
			//n이 k로 나누어떨어지면 k로 나누기
			n/=k;
			cnt++;
		}
		
		//남은 수에 대하여 n이 1일 될때까지 1씩 뺴기
		while(n>1) {
			n-=1;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}

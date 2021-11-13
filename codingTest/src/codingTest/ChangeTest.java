package codingTest;

public class ChangeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1260;	//거스름돈 금액
		int cnt = 0;	//동전의 최소 개수 저장할 변수
		int[] coinTypes = {500,100,50,10};	//거스름돈 동전 단위를 배열로 저장
		
		for(int i=0;i<4;i++) {
			int coin = coinTypes[i];	//큰 단위부터
			cnt += n/coin;	//거슬러줄 수 있는 동전의 최소 개수를 누적
			n %= coin;		//n(거스름돈)을 동전으로 나눈 나머지
		}
		System.out.println(cnt);
	}
}

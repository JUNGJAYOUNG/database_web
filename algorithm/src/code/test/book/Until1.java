package code.test.book;
import java.util.*;

public class Until1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int cnt=0;
		
		//n�� k�̻��̶�� k�� ��� ������
		while(n>=k) {
			//n�� k�� ������������ ������ 1�� ����
			while(n%k!=0) {
				n-=1;
				cnt++;
			}
			//n�� k�� ����������� k�� ������
			n/=k;
			cnt++;
		}
		
		//���� ���� ���Ͽ� n�� 1�� �ɶ����� 1�� ����
		while(n>1) {
			n-=1;
			cnt++;
		}
		
		System.out.println(cnt);
	}
}

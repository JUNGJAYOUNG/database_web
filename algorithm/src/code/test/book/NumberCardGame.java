package code.test.book;
import java.util.*;

public class NumberCardGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int row=sc.nextInt();
		int col=sc.nextInt();
		int result = 0;
		
		//���پ� �Է¹޾� Ȯ���ϱ�
		for(int i=0 ; i<row ; i++) {
			//���� �߿��� '���� ���� ��' ã��
			int min = 10001;
			for(int j=0 ; j<col ; j++) {
				int x = sc.nextInt();
				min = Math.min(min, x);
			}
			//'���� ���� ��'�� �߿��� ���� ū �� ã��
			result = Math.max(result, min);
		}
		System.out.println(result);
	}

}

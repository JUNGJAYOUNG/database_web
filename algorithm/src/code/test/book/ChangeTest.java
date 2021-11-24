package code.test.book;

public class ChangeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1260;	//�Ž����� �ݾ�
		int cnt = 0;	//������ �ּ� ���� ������ ����
		int[] coinTypes = {500,100,50,10};	//�Ž����� ���� ������ �迭�� ����
		
		for(int i=0;i<4;i++) {
			int coin = coinTypes[i];	//ū ��������
			cnt += n/coin;	//�Ž����� �� �ִ� ������ �ּ� ������ ����
			n %= coin;		//n(�Ž�����)�� �������� ���� ������
		}
		System.out.println(cnt);
	}
}

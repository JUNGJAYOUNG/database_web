package code.test.book;
import java.util.*;

public class MaxNumberRule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		//N, M, K�� ������ �������� �����Ͽ� �Է¹ޱ�
		int n = sc.nextInt();	//�迭�� ũ��
		int m = sc.nextInt();	//���ڰ� �������� Ƚ��
		int k = sc.nextInt();	//�ʰ��ؼ� �������� ���� �� ���� ���� Ƚ��
		
		//N���� ���� ������ �������� �����Ͽ� �Է¹ޱ�
		int []arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr); //.sort() �迭����
		int first = arr[n-1];	//���� ū��
		int second = arr[n-2];	//�ι�°�� ū��
		
		/*�ܼ��ϰ� Ǫ�� ���
		//���� ū���� k�� ���ϰ� �ι�°�� ū ���� �ѹ� ���ϴ� ������ �ݺ�
		int result = 0;
		while(true) {
			for(int i=0;i<k;i++) {	//����ū�� k�� ���ϱ�
				if(m==0)	//��ü ���ϱ� Ƚ�� 0�̸� Ż��
					break;
				result += first; //����ū�� ����
				m-=1;	//���Ҷ����� ���ϱ� Ƚ�� ����
			}
			if(m==0)	//��ü ���ϱ� Ƚ�� 0�̸� while�� �ƿ� Ż��
				break;
			result += second;	//�ι�°�� ū �� �ѹ� ���ϱ�
			m-=1;
		}
		*/
		
		//���������� Ǫ�� ���
		int cnt = (m/(k+1))*k;	//���� ū ���� �������� Ƚ�� ���
		cnt += m % (k+1);	//k+1�� �� �������� ������� �׸�ŭ ���� ū���� �� ���ϱ�
		
		int result = 0;
		result += cnt * first; //���� ū �� ���ϱ�
		result += (m - cnt) * second;//���� ū �� �� ���ϰ� ���� Ƚ����ŭ �ι�°�� ū �� ���ϱ�
		
		System.out.println(result);
	}

}

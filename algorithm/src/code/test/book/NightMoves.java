package code.test.book;
import java.util.*;

public class NightMoves {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//���� ����Ʈ�� ��ġ �Է¹ޱ�
		String inputData = sc.nextLine();
		int row = inputData.charAt(1) - '0';
		int col = inputData.charAt(0) - 'a' + 1;
		
		//����Ʈ�� �̵��� �� �ִ� 8���� ���� ����
		int[] dx = {-2,-1,1,2,2,1,-1,-2};
		int[] dy = {-1,-2,-2,-1,1,2,2,1};
		
		//8���� ���⿡ ���Ͽ� �� ��ġ�� �̵��� �������� Ȯ��
		int result = 0;
		for(int i=0;i<8;i++) {
			int nextRow = row + dx[i];
			int nextCol = col + dy[i];
			//�ش� ��ġ�� �̵��� �����ϴٸ� ī��Ʈ ����
			if(nextRow >=1 && nextRow <=8 && nextCol >=1 && nextCol <=8) {
				result+=1;
			}
		}
		System.out.println(result);
	}
}

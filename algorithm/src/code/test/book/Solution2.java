package code.test.book;
import java.util.*;

public class Solution2 {
	public static int[] solution(String[] S) {
	     int[] result = new int[3];
	     
	     for(int i=0;i<S.length;i++) {	//S�� ��� �ε��� 0...n����
	    	 for(int j=i+1;j<S.length;j++) {	//���� �ٸ� s�� ��� �ε���
	    		 for(int k=0;j<S[i].length();j++) {	//���ڿ� �ϳ� ���� �ε���
	    			 if(S[i].charAt(k)==S[j].charAt(k)) {
	    				 result[0]=i;
		    			 result[1]=j;
		    			 result[2]=k; 
	    			 }
	    		} 
	    	 }
	    	 
	     }   
	     return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String[] S = new String[n];
		for(int i=0;i<n;i++) {
			S[i] = sc.next();
		}
		
		int[] result = solution(S);
		
		System.out.println(result[0]+","+result[1]+","+result[2]);
	}

}

package codingTest;
import java.util.*;

public class Solution2 {
	public static int[] solution(String[] S) {
	     int[] result = new int[3];
	     
	     for(int i=0;i<S.length;i++) {	//S의 요소 인덱스 0...n까지
	    	 for(int j=i+1;j<S.length;j++) {	//비교할 다른 s의 요소 인덱스
	    		 for(int k=0;j<S[i].length();j++) {	//문자열 하나 안의 인덱스
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

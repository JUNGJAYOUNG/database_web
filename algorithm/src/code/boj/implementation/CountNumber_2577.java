package code.boj.implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CountNumber_2577 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//Scanner보다 BufferedReader가 효율좋음
		
		String a=br.readLine();
		String b=br.readLine();
		String c=br.readLine();
		int[] cnt = new int[10];
		int n = Integer.parseInt(a)*Integer.parseInt(b)*Integer.parseInt(c);
		
		String str = String.valueOf(n); //String.valueOf()로 int형 String형으로 변환
		
		for(int i=0;i<str.length();i++) {
			cnt[(str.charAt(i)-48)]++;	//charAt을 쓸 경우엔 -'0' -48을 연산해야한다.(안그러면 아스키코드에 대응하는 문자가 나온다)
		}
		for(int v:cnt) {
			System.out.println(v);
		}
	}
}

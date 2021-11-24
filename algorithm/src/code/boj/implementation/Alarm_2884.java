package code.boj.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alarm_2884 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");	//공백으로 분리해서 string 배열로 저장
		int h=Integer.parseInt(str[0]);				//Integer.parseInt()로 int형으로 바꾸기
		int m=Integer.parseInt(str[1]);
		
		/*
		Scanner sc = new Scanner(System.in);

		int h=sc.nextInt();
		int m=sc.nextInt();
		sc.close();	//더이상 입력받지 않으니 close해주는 것이 좋다.?
		*/
		if(m<45) {
			h--;
			m=60-(45-m);
			if(h<0)
				h=23;
			System.out.println(h+" "+m);
		
		}else {
			System.out.println(h+" "+(m-45));
		}
		
		
	}

}

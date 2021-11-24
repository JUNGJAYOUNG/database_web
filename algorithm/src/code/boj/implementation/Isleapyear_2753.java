package code.boj.implementation;

import java.util.Scanner;

public class Isleapyear_2753 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		
		if(n%4==0 && n%100!=0 || n%400==0) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
			
	
	}

}

package code.test.book;
import java.util.*;

public class Solution {
	
	public static String solution(String[] phone_numbers, String[] phone_owners, String number) {
		String result="";
		for(int i=0;i<phone_numbers.length;i++) {
			if(number.equals(phone_numbers[i])) {
				result = phone_owners[i];
			}
		}
		if(result.equals(""))
			result = number;
   
		return result;
	}
	public static void main(String[] args) {
		String[] phone_numbers = {"234-567-890","444-444-444","321-543-234"};
		String[] phone_owners = {"Harry","Nick","Michael"};
		
		Scanner sc = new Scanner(System.in);
		
		String number = sc.nextLine();
		String result = solution(phone_numbers,phone_owners,number);
		System.out.println(result);
		
	}
}

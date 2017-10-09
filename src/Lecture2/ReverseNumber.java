package Lecture2;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		int Rev = 0;
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the number you want reversed : ");
		int n = scn.nextInt();
		int m=n;
		while(n>0)
		{
			Rev = Rev*10 + n%10;
			n/=10;
		}
System.out.println("The reverse of "+m+" is "+Rev);
scn.close();
	}
	public static int Reverse(int n){
		int Rev=0;
		while(n>0)
		{
			Rev = Rev*10 + n%10;
			n/=10;
		}
		return Rev;
	}

}

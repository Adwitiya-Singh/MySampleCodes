package Lecture2;

import java.util.Scanner;

public class IfIsPrime {

	public static void main(String[] args) {
		System.out.println(IsPrime(8));
		
	}
	public static boolean IsPrime(int N){
		if(N==1){
			return false;
		}
		for(int i=2;i<=Math.sqrt(N);i++)
		{
			if(N%i==0) 
			{
				return false;
			}
		}
return true;     
	}

}

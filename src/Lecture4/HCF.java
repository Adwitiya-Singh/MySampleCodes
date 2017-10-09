package Lecture4;

import java.util.Scanner;

public class HCF {

	public static void main(String[] args) {
		char cont = 'y';

		while (cont == 'y') {
		Scanner scn = new Scanner(System.in);
		int a,b,min,hcf=1;
		System.out.println("Enter two numbers whose HCF you want");
		a = scn.nextInt();
		b = scn.nextInt();
		if (a > b)
			min = b;
		else
			min = a;
		for(int i=min;i>0;i--)
		{
			if(a%i==0&&b%i==0){
				hcf=i;
				break;
			}
		}
		System.out.println("HCF of "+a+" and "+b+" is "+hcf);
		System.out.println("Do you wanna continue?(y/n)");
		cont = scn.next().charAt(0);
		if (cont == 'n')
			scn.close();
	}
	}

}

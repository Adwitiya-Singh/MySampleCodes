package Patterns;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
	int i,counter=1;
	Scanner scn = new Scanner(System.in);
	i=scn.nextInt();
	for(int j=1;j<=i;j++){
		for(int k=0;k<j;k++){
			System.out.print(counter+" ");
			counter++;
		}
		System.out.println();
	}
	}

}

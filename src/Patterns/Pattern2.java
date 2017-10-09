package Patterns;

import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		for (int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				if(j==1||j==i){
					System.out.print(i+"\t");
				}
				else System.out.print(0+"\t");
			}
			System.out.println();
		}

	}

}

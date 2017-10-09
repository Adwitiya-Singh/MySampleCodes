package Lecture3;

import java.util.Scanner;

public class Pattern3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();
		int ctr = N / 2 ;
		int ctrtwo = 1;
		for (int i = 0; i < N / 2 + 1; i++) {
			for (int j = 0; j < ctr; j++) {
				System.out.print("\t");
			}
			for (int x = 0; x < ctrtwo; x++) {
				System.out.print("*\t");
			}
			ctrtwo += 2;
			ctr--;
			System.out.println();
		}
		int counter=1;
		int countertwo=N-2;
		for(int l=0;l<N/2;l++){
			for(int g=0;g<counter;g++){
				System.out.print("\t");
			}
			for(int d=0;d<countertwo;d++){
				System.out.print("*\t");
			}
			countertwo-=2;
			counter++;
			System.out.println();
		}
	}
	}



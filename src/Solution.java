

import java.util.Scanner;

public class Solution {
	   public static void main(String[] args) {
		      int r, i, k, number = 1, j;
				Scanner scn = new Scanner(System.in);

//				r = scn.nextInt();
r=5;
				for (i = 0; i < r; i++) {
					
					number = 1;
					for (j = 0; j <= i; j++) {
						System.out.print(number + " ");
						number = number * (i - j) / (j + 1);
					}
					System.out.println();
				}
		   PrintPattern(5,0,0,1);
		    }
	   public static void PrintPattern(int N,int row,int col,int value) {
			if(row>=N){
				return;
			}
		if(row<col){
			System.out.println();
			PrintPattern(N, row+1, 0,1);
			return;
		}
		System.out.print(value + " ");
		value = value * (row - col) / (col + 1);
		PrintPattern(N,row,col+1,value);
	   }
}

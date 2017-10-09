package Lecture2;

import java.util.Scanner;

public class isEven {

	public static void main(String[] args) {
		int i;
		Scanner scn = new Scanner(System.in);
		i = scn.nextInt();
		if(i%2==1){
			System.out.println("IZ NOT PRIME");
		}else{
			System.out.println("PRIME YAYAYA!!!");
		}
	}

}

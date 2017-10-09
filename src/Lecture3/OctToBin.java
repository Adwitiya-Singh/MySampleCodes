package Lecture3;

import java.util.Scanner;

public class OctToBin {

    public static void main(String args[])
    {
    	char cont = 'y';

		while (cont == 'y') {
  			  Scanner scn = new Scanner(System.in);
  			  System.out.print("Enter Octal Value ");
  			  int oct=scn.nextInt();
  			  int dec=OctToDec(oct);
  			  System.out.println(oct+" in Binary is ");
  			  DecToBin(dec);
  			System.out.print("Do you wanna continue?(y/n)");
  			cont = scn.next().charAt(0);
  			if (cont == 'n')
  				scn.close();
  		}

  	}
  			  	    public static int OctToDec(int oct)
  			  	    {
  			  	        int dec=0, i=0;
  			  	        
  			  	        
  			  			
  			  	        while(oct != 0)
  			  	        {
  			  	            dec = dec + (oct%10) * (int) Math.pow(8, i);
  			  	            i++;
  			  	            oct = oct/10;
  			  	        }
  			  			
  			  	        return dec;
  			  	    }
  			  	    public static void DecToBin(int num){
  			  	        int binary[] = new int[40];
  			  	        int index = 0;
  			  	        while(num > 0){
  			  	          binary[index++] = num%2;
  			  	          num = num/2;
  			  	        }
  			  	        for(int i = index-1;i >= 0;i--){
  			  	          System.out.print(binary[i]);
  			  	        }
  			  	     }

    }
 
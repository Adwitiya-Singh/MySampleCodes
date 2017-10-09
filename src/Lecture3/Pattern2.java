package Lecture3;

import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
  Scanner scn = new Scanner(System.in);
	      
	      int N = scn.nextInt();
	      
	      for(int i=1;i<=N/2+1;i++){
	    	  for(int j=(N/2)-i+2;j>0;j--){
	    		  System.out.print("*\t");
	    	  }
	    	  for(int k=2*i-1;k>0;k--){
	    		  System.out.print("\t");
	    	  }
	    	  for(int j=(N/2)-i+2;j>0;j--){
	    		  System.out.print("*\t");
	    	  }
	    	  System.out.println();
	      }
	      int counter =2;
	      int countertwo=N-2;
	      for(int i=0;i<(N-1)/2;i++){
	    	  for(int x=0;x<counter;x++){
	    		  System.out.print("*\t");
	    	  }
	    	  for(int z=0;z<countertwo;z++){
	    		  System.out.print("\t");
	    	  }
	    	  for(int x=0;x<counter;x++){
	    		  System.out.print("*\t");
	    	  }
	    	  System.out.println();
	    	  counter++;
	    	  countertwo-=2;
	      }
	}

	}



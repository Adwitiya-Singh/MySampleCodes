package Lecture3;

import java.util.Scanner;

public class AnyToAny {
	public static void main(String[] args) {
		char cont = 'y';

		while (cont == 'y') {
		int Sb,Db,Sv,Dv;
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter Source Base ");
		Sb=scn.nextInt();
		System.out.print("Enter Destination Base ");
		Db=scn.nextInt();
		System.out.print("Enter Source Value ");
		Sv=scn.nextInt();
		Dv=AnytoDec(Sv,Sb);
		System.out.print(Sv+" in base "+Db+" is " );
		DectoAny(Dv,Db);
		System.out.print("Do you wanna continue?(y/n) ");
		cont = scn.next().charAt(0);
		if (cont == 'n')
			scn.close();
	}
	  
	}
	
	    public static int AnytoDec(int sv, int sb) {
	    	int dec=0, i=0;
	  	        
	  	      
	  			
	  	        while(sv != 0)
	  	        {
	  	            dec = dec + (sv%10) * (int) Math.pow(sb, i);
	  	            i++;
	  	            sv = sv/10;
	  	        }
		return dec;
	}

		public static void DectoAny(int n,int b)
	    {
	    	
	    
	    	int q=n,r;
	    	String ans="";
	    	while(q!=0)
	    	{
	    	r=q%b;
	    	ans=r+ans;
	    	q=q/b;
	    	}
	    	System.out.println(ans);
	    	}

		
}

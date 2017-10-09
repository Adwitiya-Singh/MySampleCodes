package Lecture10;

import javax.sound.midi.Synthesizer;

public class PreciseSQRT {
public static void main(String args[]){
	double i=SquareRoot(10,3);
	System.out.println(i);
}
public static double SquareRoot(int n,int p){
	double SQRT=0;
	int ipower=1;
	double dpower=1.0;
	double increment=1;
	int counter=0;
	while(counter<=p){
		while(SQRT*SQRT<=n){
			SQRT+=increment;
			
			System.out.println(Math.round((SQRT*ipower)/dpower));
		}
		
		SQRT-=increment;
		increment*=0.1;
		ipower*=10;
		dpower*=10.0;
		counter++;
	}
	return SQRT;
}
}

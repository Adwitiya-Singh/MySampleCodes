package Lecture2;

public class WhichPrime {

	public static void main(String[] args) {
System.out.println(WhichPrime(11));
//System.out.println(NthPrimeFromEnd(2, 10));
	}
	public static int WhichPrime(int N){
		int ctr=0;
		for(int i=2;i<=N;i++){
			if(IfIsPrime.IsPrime(i)){
				ctr++;
			}
		}
		return ctr;
	}
	public static int NthPrimeFromEnd(int N,int limit){
		int ctr=0;
		for(int i=limit;i>0;i--){
			if(IfIsPrime.IsPrime(i)){
				ctr++;
				if(ctr==N){
					return i;
				}
			}
		}
		return 0;
	}

}

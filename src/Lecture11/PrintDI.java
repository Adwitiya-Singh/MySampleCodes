package Lecture11;

public class PrintDI {

	public static void main(String[] args) {
		// PrintDI(5);
		PrintDISkip(5);

	}

	public static void PrintDI(int i) {
		if (i <= 0) {
			return;
		}
		System.out.println(i);
		PrintDI(i - 1);
		System.out.println(i);

	}

public static void PrintDISkip(int i){
	if(i<=0){
		return;
	}
if(i%2!=0){
	System.out.println(i);
}
PrintDISkip(i-1);
if(i%2==0){
	System.out.println(i);


}
}
}

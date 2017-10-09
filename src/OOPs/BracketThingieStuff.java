package OOPs;

import java.util.Scanner;

public class BracketThingieStuff {
	public static void BracketsSomething(String str){
		DynamicStack st = new DynamicStack();
		for (int i=0;i<str.length();i++){
			if(str.charAt(i)=='{'||str.charAt(i)=='['||str.charAt(i)=='('){
				st.push((int)str.charAt(i));
			}
			if(str.charAt(i)=='}'||str.charAt(i)==']'||str.charAt(i)==')'){
				try{
				if((int)str.charAt(i)==st.top()+1||(int)str.charAt(i)==st.top()+2){
					st.pop();
				}
				}catch(Exception ex){

	System.out.println("not balanced");
	return;
				}
			}
			
		}
		if(st.size()==0){
			System.out.println("balanced");
		}
		else System.out.println("not balanced");
	}
	
	public static void main(String[] args)  {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a String with brackets to check for balanced-ness");
		String str = scn.nextLine();
		System.out.print("The string is ");
		BracketsSomething(str);
}
}

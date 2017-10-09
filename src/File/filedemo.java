package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class filedemo {

	public static void main(String[] args) {
		try{
File x = new File("/Users/adwitiyasingh/Desktop/Untitled.txt");
if(x.exists()){
	System.out.println(x.getName()+" exists!");
}
else{
	System.out.println("Fail!");
}
Scanner scn = new Scanner(x);
while(scn.hasNext()){
	System.out.print(scn.next()+" ");
}
	}catch(FileNotFoundException f){
		System.out.print(f.getMessage());
	}
	}

}

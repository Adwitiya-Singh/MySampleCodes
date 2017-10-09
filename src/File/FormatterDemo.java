package File;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class FormatterDemo {

	public static void main(String[] args) {
		try {
			Formatter f = new Formatter("/Users/adwitiyasingh/Desktop/Untitled.txt");
f.format("%s %s %s", "1","Karan","Singh\r\n");
f.format("%s %s %s", "2","Aryan","Singh\r\n");
f.close();

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}

}

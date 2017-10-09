package Tries;

public class TriesClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            Tries lang = new Tries();
         
            lang.addWords("arts");
            lang.addWords("art");
            lang.addWords("stop");
            lang.addWords("stock");
            lang.addWords("see");
            lang.addWords("sea");
           System.out.println(lang.numWords());
            lang.DisplayAsWords();
	}

}

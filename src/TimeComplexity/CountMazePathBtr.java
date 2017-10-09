package TimeComplexity;

public class CountMazePathBtr {

	public static void main(String[] args) {

		System.out.println(CountMazePathBtr1(0, 0, 3, 3, new int[4][4]));
	}

	public static int CountMazePathBtr1(int cr, int cc, int er, int ec, int[][] storage) {
		int Count = 0;
		if (cr > er || cc > ec) {
			return 0;
		}
		if (er == cr && ec == cc) {
			return 1;
		}
		if (storage[cr][cc] != 0) {
					return storage[cr][cc];
		}
		Count += CountMazePathBtr1(cr + 1, cc, er, ec, storage);
		Count += CountMazePathBtr1(cr, cc + 1, er, ec, storage);
		storage[cr][cc] = Count;

		// if(cr==cc||cr+cc=e=c) CONDITIONAL DIOGNAL
		// Count += CountMazePath(er, ec, cr + 1, cc + 1); //FOR DIAGONALS

		return Count;
	}
}

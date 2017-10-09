package Lecture11;

import Lecture2.IfIsPrime;
import Lecture2.WhichPrime;

public class RecursionThree {

	public static void main(String[] args) {
		// System.out.println(CBPwithLadders(10, 0));
		// PBPwithLadders(10, 0, "0 ");
		// PBPwithLaddersandSnakes(13, 0, "0 ");
//		printNRooks(4);
		// SmallerDictionaryPermutations("bac", "", false, "bac");
		// ReverselexicographicalPrint(1000, 0);
		// System.out.println(lalala(3, 3, 0, 0));
		 Printlalala(4, 4, 0, 0, "");

	}

	public static int CBPwithLadders(int Final, int now) {
		int times = 0;
		if (now == Final) {
			return 1;
		}
		if (now > Final) {
			return 0;
		}

		for (int i = 1; i < 7; i++) {
			if (Lecture2.IfIsPrime.IsPrime(now + i)) {

				int lastprime = WhichPrime.NthPrimeFromEnd(1, Final);
				int lastwhich = WhichPrime.WhichPrime(lastprime);
				int midwhich = lastwhich / 2;
				int nowwhich = WhichPrime.WhichPrime(now + i);
				if (nowwhich <= midwhich) {
					int posn = WhichPrime.NthPrimeFromEnd(nowwhich, Final);
					times = times + CBPwithLadders(Final, posn);
				} else {
					times = times + CBPwithLadders(Final, now + i);
				}
			} else {
				times = times + CBPwithLadders(Final, now + i);
			}
		}

		return times;
	}

	public static void PBPwithLadders(int Final, int now, String strnow) {
		if (now == Final) {

			System.out.println(strnow);
			return;

		}

		if (now > Final) {
			return;
		}

		for (int i = 1; i < 7; i++) {
			if (Lecture2.IfIsPrime.IsPrime(now + i)) {

				int lastprime = WhichPrime.NthPrimeFromEnd(1, Final);
				int lastwhich = WhichPrime.WhichPrime(lastprime);
				int midwhich = lastwhich / 2;
				int nowwhich = WhichPrime.WhichPrime(now + i);
				if (nowwhich <= midwhich) {
					int posn = WhichPrime.NthPrimeFromEnd(nowwhich, Final);
					PBPwithLadders(Final, posn, strnow + (now + i) + " LADDER TO " + (posn) + " ");
				} else {
					PBPwithLadders(Final, now + i, strnow + (now + i) + " ");
				}
			} else {
				PBPwithLadders(Final, now + i, strnow + (now + i) + " ");
			}
		}
	}

	public static void PBPwithLaddersandSnakes(int Final, int now, String strnow) {
		if (now == Final) {

			System.out.println(strnow);
			return;

		}

		if (now > Final) {
			return;
		}

		for (int i = 1; i < 7; i++) {
			if (Lecture2.IfIsPrime.IsPrime(now + i)) {

				int lastprime = WhichPrime.NthPrimeFromEnd(1, Final);
				int lastwhich = WhichPrime.WhichPrime(lastprime);
				int midwhich = lastwhich / 2;
				int nowwhich = WhichPrime.WhichPrime(now + i);
				if (nowwhich < midwhich && nowwhich % 2 == 1 || nowwhich == midwhich && lastwhich % 2 == 0) {
					int posn = WhichPrime.NthPrimeFromEnd(nowwhich, Final);
					PBPwithLadders(Final, posn, strnow + (now + i) + " " + (posn) + " ");
				} else if (nowwhich > midwhich + 1 && nowwhich % 2 == 0 && lastwhich % 2 == 1
						|| nowwhich > midwhich && nowwhich % 2 == 0 && lastwhich % 2 == 0) {
					int posn = WhichPrime.NthPrimeFromEnd(nowwhich, Final);
					PBPwithLadders(Final, posn, strnow + (now + i) + " " + (posn) + " ");
				} else {
					PBPwithLadders(Final, now + i, strnow + (now + i) + " ");
				}
			} else {
				PBPwithLadders(Final, now + i, strnow + (now + i) + " ");
			}
		}
	}

	public static void printNRooks(int N) {
		boolean[][] board = new boolean[N][N];
		printNRooks(board, 0, "");
	}

	public static void printNRooks(boolean[][] board, int row, String strnow) {
		if (row == board.length) {
			System.out.println(strnow + "FIN");
			return;
		}
			for (int col = 0; col < board.length; col++) {
				if (isItSafeTPR(board, row, col)) {
					board[row][col] = true;
					printNRooks(board, row, strnow + "(" + row + "-" + col + "), ");
					board[row][col] = false;

				}
			
		}
	}

	public static boolean isItSafeTPR(boolean[][] board, int row2check, int col2check) {
		if (row2check > 0) {

			if (board[row2check - 1][col2check] == true)
				return false;
		}
		if (row2check > 0 && col2check < board.length - 1) {
			if (board[row2check - 1][col2check + 1] == true)
				return false;

		}
		if (row2check > 0 && col2check > 0) {
			if (board[row2check - 1][col2check - 1] == true)
				return false;
		}

		return true;
	}

	public static void SmallerDictionaryPermutations(String str, String Now, Boolean Flag, String original) {
		if (str.length() == 0) {
			if (Now.equals(original)) {
				return;
			}
			System.out.println(Now);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			if (Flag) {
				char cc = str.charAt(i);
				String strnow = str.substring(0, i) + str.substring(i + 1);
				SmallerDictionaryPermutations(strnow, Now + cc, Flag, original);
			} else {
				char cc = str.charAt(i);

				if (cc <= str.charAt(0)) {
					String strnow = str.substring(0, i) + str.substring(i + 1);
					SmallerDictionaryPermutations(strnow, Now + cc, Flag || cc < str.charAt(0), original);
				}
			}
		}

	}

	public static void LargerDictionaryPermutations(String str, String Now, Boolean flag, String original) {
		if (str.length() == 0) {
			if (Now.equals(original)) {
				return;
			}
			System.out.println(Now);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			if (flag) {
				char cc = str.charAt(i);
				String strnow = str.substring(0, i) + str.substring(i + 1);
				LargerDictionaryPermutations(strnow, Now + cc, flag, original);
			} else {
				char cc = str.charAt(i);
				if (cc >= str.charAt(0)) {
					String strnow = str.substring(0, i) + str.substring(i + 1);
					LargerDictionaryPermutations(strnow, Now + cc, flag || cc > str.charAt(0), original);
				}
			}
		}
	}

	public static void ReverselexicographicalPrint(int N, int now) {

		if (now > N) {
			return;
		}

		for (int i = 9; i > (now == 0 ? 0 : -1); i--) {
			ReverselexicographicalPrint(N, now * 10 + i);

		}
		if (now <= N) {
			System.out.println(now);
		}
	}

	public static int lalala(int er, int ec, int cr, int cc) {
		int count = 0;
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		int placenow = cr * (er + 1) + (cc + 1);
		if (IfIsPrime.IsPrime(placenow)) {
			int which = WhichPrime.WhichPrime(placenow);
			if (which % 2 == 1) {
				return 0;
			} else
				count += lalala(er, ec, er, ec);
		}
		if (cr == 0 || cr == er || cc == 0 || cc == ec) {
			for (int i = 1; i < er; i++) {
				count += lalala(er, ec, cr + i, cc);
				count += lalala(er, ec, cr, cc + i);
			}
		}
		if (cr == cc || (cr + cc) == er) {
			for (int i = 1; i < er; i++) {
				count += lalala(er, ec, cr + i, cc + i);
			}
		}
		count += lalala(er, ec, cr + 2, cc + 1);
		count += lalala(er, ec, cr + 1, cc + 2);

		return count;
	}

	public static void Printlalala(int er, int ec, int cr, int cc, String Strnow) {
		int placenow = cr * (er + 1) + (cc + 1);
		if (cr == er && cc == ec) {
			Strnow += placenow + " ";
			System.out.println(Strnow);
			return;
		}
		if (cr > er || cc > ec) {
			return;
		}
		if (IfIsPrime.IsPrime(placenow)) {
			int which = WhichPrime.WhichPrime(placenow);
			if (which % 2 == 1) {
				return;
			} else
				Printlalala(er, ec, er, ec, Strnow + placenow + " ");
		}
		if (cr == 0 || cr == er || cc == 0 || cc == ec) {
			for (int i = 1; i < er; i++) {
				Printlalala(er, ec, cr + i, cc, Strnow + placenow + " ");
				Printlalala(er, ec, cr, cc + i, Strnow + placenow + " ");
			}
		}
		if (cr == cc || (cr + cc) == er) {
			for (int i = 1; i < er; i++) {
				Printlalala(er, ec, cr + i, cc + i, Strnow + placenow + " ");
			}
		}
		Printlalala(er, ec, cr + 2, cc + 1, Strnow + placenow + " ");
		Printlalala(er, ec, cr + 1, cc + 2, Strnow + placenow + " ");

	}

}

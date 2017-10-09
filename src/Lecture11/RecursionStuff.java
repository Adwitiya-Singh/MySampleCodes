package Lecture11;

import java.util.ArrayList;

import Lecture6.ArrayStuff;

public class RecursionStuff {

	public static void main(String[] args) {
		// int[] a = { 6, 4, 7, 9, 3, 5, 22, 6 };
		// System.out.println(ReturnFirstIndex(a, 0, 6) + 1);
		// System.out.println(ReturnLastIndex(a, 0, 6) + 1);
		// System.out.println(IsSorted(a, 0));
		// Bblsort(a, 0, a.length - 1);
		//
		// for (int i = 0; i < a.length; i++) {
		// System.out.print(a[i] + " ");
		// }
		// System.out.println();
		// System.out.println(ReturnFirstIndex(a, 0, 6) + 1);
		// System.out.println(ReturnLastIndex(a, 0, 6) + 1);
		// System.out.println(IsSorted(a));
		// System.out.println(IsPresent(a, 0, 4));
		// System.out.println(IsPresent(a, 1));
		// PrintPattern(5, 1, 1);
		// PrintPascalsTriangle(5, 0, 0, 1);
		// int[] arrtwo = { 1, 2, 3, 1, 2, 3, 1, 2, 3, 4 };
		// int[] Howmany = ReturnAllIndices(arrtwo, 3, 0, 0);
		// for (int i = 0; i < Howmany.length; i++) {
		// System.out.print(Howmany[i] + 1 + " ");
		// }
		// System.out.println(ConvertToNumber("6969"));
//		 System.out.println(CountMazePath(5, 5, 1, 1));
		// System.out.println(SumUntil(3));
		// subString("123", 0, 3);
		// System.out.println(CountBoardPath(10, 0));
		// SelectionSort(a, 0, 1);
		// ArrayStuff.display(a);
		// PatternTwo(5, 1, 1);
		// System.out.println(Subsequences("abc"));
//		 System.out.println(SubsequencesWithAscii("try").s);
		// System.out.println(Permutations("abcd"));
		 System.out.println(Keypad("90"));
		// String str="AdwitiyayitiwdA";
		// System.out.println(IsPalindrome(str, 0, str.length()-1));
		// ReverseArray(a, 0, a.length-1);
		// ArrayStuff.display(a);
		// int[] ToBInverted={3,2,1,4,5};
		// ArrayStuff.display(inverseArray(ToBInverted, 0));
		// System.out.println(ReturnBoardPath(2, 0));
		// PrintSS("abc","");
		// PrintSSWA("abc", "");
		// PrintPermutations("abab", "");
		// System.out.println();
		// PrintPermutationsWithoutDuplicates("abab", "");
		// PrintMazePath(2, 2, 0, 0, "");
		// System.out.println("FIN");
		// System.out.println(ReturnMazePath(2, 2, 0, 0, ""));
		// System.out.println(SumOfString("123"));

	}

	public static void PrintPascalsTriangle(int N, int row, int col, int value) {
		if (row >= N) {
			return;
		}
		if (row < col) {
			System.out.println();
			PrintPascalsTriangle(N, row + 1, 0, 1);
			return;
		}
		System.out.print(value + " ");
		value = value * (row - col) / (col + 1);
		PrintPascalsTriangle(N, row, col + 1, value);

	}

	public static void Bblsort(int[] a, int si, int li) {
		if (li == 0) {
			return;
		}
		if (si == li) {
			Bblsort(a, 0, li - 1);
			return;
		}
		if (a[si] > a[si + 1]) {
			Lecture6.ArrayStuff.swap(a, si, si + 1);
		}

		Bblsort(a, si + 1, li);

	}

	public static boolean IsSorted(int[] arr) {
		if (arr.length == 1) {
			return true;
		}

		if (arr[0] > arr[1]) {
			return false;
		}
		int[] sa = new int[arr.length - 1];
		for (int i = 1; i < arr.length; i++) {
			sa[i - 1] = arr[i];

		}
		Boolean IsSasorted = IsSorted(sa);
		return IsSasorted;
	}

	public static boolean IsPresent(int[] arr, int n) {
		if (arr.length == 0) {
			return false;
		}
		if (arr[0] == n) {
			return true;
		}
		int[] sa = new int[arr.length - 1];
		for (int i = 1; i < arr.length; i++) {
			sa[i - 1] = arr[i];
		}
		boolean IsItPresent = IsPresent(sa, n);
		return IsItPresent;
	}

	public static boolean IsPresent(int[] arr, int si, int n) {
		if (si > arr.length - 1) {
			return false;
		}
		if (arr[si] == n) {
			return true;
		}
		boolean IsItPresent = IsPresent(arr, si + 1, n);
		return IsItPresent;
	}

	public static boolean IsSorted(int[] arr, int si) {

		if (si == arr.length - 2) {
			return true;
		}
		if (arr[si + 1] < arr[si]) {
			return false;
		}
		Boolean IsSasorted = IsSorted(arr, si + 1);
		return IsSasorted;
	}

	public static void PrintPattern(int N, int row, int col) {
		if (row > N) {
			return;
		}
		if (row < col) {
			System.out.println();
			PrintPattern(N, row + 1, 1);
			return;
		}
		System.out.print("* ");
		PrintPattern(N, row, col + 1);

	}

	public static int ReturnFirstIndex(int[] arr, int index, int value) {
		if (index > arr.length - 1) {
			return -1;
		}
		if (arr[index] == value) {
			return index;
		}
		int WhereIsIt = ReturnFirstIndex(arr, index + 1, value);
		return WhereIsIt;
	}

	public static int ReturnLastIndex(int[] arr, int index, int value) {
		if (index > arr.length - 1) {
			return -1;
		}

		int WhereIsIt = ReturnLastIndex(arr, index + 1, value);
		if (WhereIsIt == -1) {
			if (arr[index] == value) {
				return index;
			}

		}

		return WhereIsIt;
	}

	public static int[] ReturnAllIndices(int[] arr, int value, int index, int howmany) {
		int[] Final;
		if (index >= arr.length) {
			int[] Size = new int[howmany];
			return Size;
		}
		if (arr[index] == value) {

			Final = ReturnAllIndices(arr, value, index + 1, howmany + 1);
		} else {
			Final = ReturnAllIndices(arr, value, index + 1, howmany);
		}
		if (arr[index] == value) {

			Final[howmany] = index;
			return Final;
		}
		return Final;
	}

	public static int ConvertToNumber(String s) {
		int Converted = 0;
		if (s.length() == 1) {

			return s.charAt(0) - '0';
		}
		char a = s.charAt(s.length() - 1);
		s = s.substring(0, s.length() - 1);
		Converted = ConvertToNumber(s);
		Converted = Converted * 10;
		Converted = Converted + (a - '0');

		return Converted;

	}

	public static int CountMazePath(int er, int ec, int cr, int cc) {
		int Count = 0;
		if (cr > er || cc > ec) {
			return 0;
		}
		if (er == cr && ec == cc) {
			return 1;
		}
		Count += CountMazePath(er, ec, cr + 1, cc);
		Count += CountMazePath(er, ec, cr, cc + 1);
		// if(cr==cc||cr+cc=e=c) CONDITIONAL DIOGNAL
		// Count += CountMazePath(er, ec, cr + 1, cc + 1); //FOR DIAGONALS

		return Count;
	}

	public static int SumUntil(int rows) {

		if (rows == 0)
			return 0;

		return SumUntil(rows - 1) + rows;

	}

	public static int SumOfDigits(int n) {

		if (n <= 0)
			return 0;

		return SumOfDigits(n / 10) + n % 10;

	}

	public boolean NextTenTimes(int[] nums, int index) {
		if (index == nums.length - 1 || nums.length == 0) {
			return false;
		}

		if (nums[index] * 10 == nums[index + 1]) {
			return true;
		}
		return NextTenTimes(nums, index + 1);
	}

	public int countHi(String str) {
		int counter = 0;
		if (str.length() <= 1) {
			return 0;
		}
		if (str.substring(0, 2).equals("hi")) {
			counter++;
		}
		return (countHi(str.substring(1)) + counter);
	}

	public static void subString(String str, int si, int li) {
		if (li == 0) {
			return;
		}
		if (si == li) {
			subString(str, 0, li - 1);
			return;
		}
		System.out.println(str.substring(si, li));
		subString(str, si + 1, li);
	}

	public static int CountBoardPath(int Final, int now) {
		int times = 0;
		if (now == Final) {
			return 1;
		}
		if (now > Final) {
			return 0;
		}

		for (int i = 1; i < 7; i++) {
			times = times + CountBoardPath(Final, now + i);
		}

		return times;
	}

	public static void SelectionSort(int[] arr, int si, int li) {
		if (li == arr.length) {
			SelectionSort(arr, si + 1, si + 2);
			return;
		}
		if (si == arr.length) {
			return;
		}
		if (arr[si] > arr[li]) {
			ArrayStuff.swap(arr, si, li);
		}
		SelectionSort(arr, si, li + 1);
	}

	public static void PatternTwo(int N, int row, int col) {
		if (row > N) {
			return;
		}
		if (row < col) {
			PatternTwo(N, row + 1, 1);
			System.out.println();

			return;
		}
		PatternTwo(N, row, col + 1);
		System.out.print("* ");

	}

	public static ArrayList<String> Subsequences(String str) {
		if (str.length() == 0) {
			ArrayList<String> Empty = new ArrayList<String>();
			Empty.add("");
			return Empty;
		}
		char cc = str.charAt(0);
		str = str.substring(1);
		ArrayList<String> recval = Subsequences(str);
		ArrayList<String> Final = new ArrayList<String>();
		for (int i = 0; i < recval.size(); i++) {
			Final.add("" + recval.get(i));
			Final.add(cc + recval.get(i));

		}
		return Final;
	}

	public static ArrayList<String> SubsequencesWithAscii(String str) {
		if (str.length() == 0) {
			ArrayList<String> Empty = new ArrayList<String>();
			Empty.add("");
			return Empty;
		}
		char cc = str.charAt(0);
		int ca = (int) cc;
		str = str.substring(1);
		ArrayList<String> recval = SubsequencesWithAscii(str);
		ArrayList<String> Final = new ArrayList<String>();
		for (int i = 0; i < recval.size(); i++) {
			Final.add("" + recval.get(i));
			Final.add(cc + recval.get(i));
			Final.add(ca + recval.get(i));
		}
		return Final;
	}

	public static ArrayList<String> Permutations(String str) {
		if (str.length() == 0) {
			ArrayList<String> Empty = new ArrayList<String>();
			Empty.add("");
			return Empty;
		}
		char cc = str.charAt(0);
		str = str.substring(1);
		ArrayList<String> recval = Permutations(str);
		ArrayList<String> Final = new ArrayList<String>();
		for (int i = 0; i < recval.size(); i++) {
			for (int j = 0; j <= recval.get(i).length(); j++) {
				Final.add(recval.get(i).substring(0, j) + cc + recval.get(i).substring(j));
			}
		}
		return Final;

	}

	public static ArrayList<String> Keypad(String str) {
		if (str.length() == 0) {
			ArrayList<String> Empty = new ArrayList<String>();
			Empty.add("");
			return Empty;
		}

		char cc = str.charAt(0);
		str = str.substring(1);
		ArrayList<String> recval = Keypad(str);
		ArrayList<String> Final = new ArrayList<String>();
		String now = KeypadValue(cc);
		for (int i = 0; i < recval.size(); i++) {
			for (int j = 0; j < now.length(); j++) {
				Final.add(now.charAt(j) + recval.get(i));
			}
		}
		return Final;

	}

	public static String KeypadValue(char i) {

		switch (i) {
		case '1':
			return "abc";
		case '2':
			return "def";
		case '3':
			return "ghi";
		case '4':
			return "jkl";
		case '5':
			return "mno";
		case '6':
			return "pqr";
		case '7':
			return "stu";
		case '8':
			return "vwx";
		case '9':
			return "yz";
		case '0':
			return ".;";

		}
		return "";

	}

	public static boolean IsPalindrome(String str, int si, int li) {

		boolean IsIt;

		if (si > li || str.length() == 0) {
			return true;
		}
		if (str.charAt(si) == str.charAt(li)) {
			IsIt = IsPalindrome(str, si + 1, li - 1);
		} else
			return false;
		return IsIt;
	}

	public static void ReverseArray(int[] arr, int si, int li) {
		if (si > li) {
			return;
		}
		Lecture6.ArrayStuff.swap(arr, si, li);
		ReverseArray(arr, si + 1, li - 1);
	}

	public static int[] inverseArray(int[] arr, int index) {
		if (index == arr.length) {
			int[] Nothing = new int[arr.length];
			return Nothing;
		}
		int[] Final = new int[arr.length];
		Final = inverseArray(arr, index + 1);
		Final[arr[index] - 1] = index + 1;
		return Final;
	}

	public static ArrayList<String> ReturnBoardPath(int Final, int Now) {
		if (Now > Final) {
			ArrayList<String> Empty = new ArrayList<String>();
			return Empty;
		}
		if (Now == Final) {
			ArrayList<String> Empty = new ArrayList<String>();
			Empty.add("");
			return Empty;
		}
		ArrayList<String> recresult = new ArrayList<String>();
		ArrayList<String> FinalResult = new ArrayList<String>();

		for (int i = 1; i <= 6; i++) {
			recresult = ReturnBoardPath(Final, Now + i);
			for (int j = 0; j < recresult.size(); j++) {
				FinalResult.add(i + recresult.get(j));
			}
		}
		return FinalResult;
	}

	public static void PrintSS(String str, String Now) {
		if (str.length() == 0) {
			System.out.println(Now);
			return;
		}
		char cc = str.charAt(0);
		str = str.substring(1);
		PrintSS(str, Now);
		PrintSS(str, Now + cc);
	}

	public static void PrintSSWA(String str, String Now) {
		if (str.length() == 0) {
			System.out.println(Now);
			return;
		}
		char cc = str.charAt(0);
		str = str.substring(1);
		PrintSSWA(str, Now);
		PrintSSWA(str, Now + cc);
		PrintSSWA(str, Now + (int) cc);
	}

	public static void PrintPermutations(String str, String Now) {
		if (str.length() == 0) {
			System.out.println(Now);
			return;
		}
		for (int i = 0; i < str.length(); i++) {

			char cc = str.charAt(i);
			String strnow = str.substring(0, i) + str.substring(i + 1);
			PrintPermutations(strnow, Now + cc);
		}

	}

	public static void PrintPermutationsWithoutDuplicates(String str, String Now) {
		if (str.length() == 0) {
			System.out.println(Now);
			return;
		}
		boolean[] isused = new boolean[26];
		for (int i = 0; i < str.length(); i++) {

			char cc = str.charAt(i);
			String strnow = str.substring(0, i) + str.substring(i + 1);
			if (isused[cc - 'a'] == false) {
				PrintPermutationsWithoutDuplicates(strnow, Now + cc);
				isused[cc - 'a'] = true;
			}
		}
	}

	public static void PrintMazePath(int er, int ec, int cr, int cc, String now) {
		if (ec == cc && er == cr) {
			System.out.print(now + ", ");
			return;
		}
		if (ec < cc || er < cr) {
			return;
		}
		PrintMazePath(er, ec, cr + 1, cc, now + 'V');
		PrintMazePath(er, ec, cr, cc + 1, now + 'H');
		PrintMazePath(er, ec, cr + 1, cc + 1, now + 'D');

	}

	public static ArrayList<String> ReturnMazePath(int er, int ec, int cr, int cc, String Now) {
		if (ec == cc && er == cr) {
			ArrayList<String> now = new ArrayList();
			now.add(Now);
			return now;
		}
		if (ec < cc || er < cr) {
			ArrayList<String> now = new ArrayList();
			return now;
		}
		ArrayList<String> Final = new ArrayList();
		ArrayList<String> Vresult = ReturnMazePath(er, ec, cr + 1, cc, Now + 'V');
		ArrayList<String> Hresult = ReturnMazePath(er, ec, cr, cc + 1, Now + 'H');
		ArrayList<String> Dresult = ReturnMazePath(er, ec, cr + 1, cc + 1, Now + 'D');

		for (int i = 0; i < Vresult.size(); i++) {
			Final.add(Vresult.get(i));
		}
		for (int j = 0; j < Hresult.size(); j++) {
			Final.add(Hresult.get(j));
		}
		for (int k = 0; k < Dresult.size(); k++) {
			Final.add(Dresult.get(k));
		}

		return Final;
	}

	public static int SumOfString(String s) {
		int Converted = 0;
		if (s.length() == 1) {

			return s.charAt(0) - '0';
		}
		char a = s.charAt(s.length() - 1);
		s = s.substring(0, s.length() - 1);

		Converted += (a - '0');
		Converted += SumOfString(s);
		return Converted;
	}

}

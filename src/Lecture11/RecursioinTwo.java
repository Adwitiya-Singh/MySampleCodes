package Lecture11;

import java.util.ArrayList;

public class RecursioinTwo {

    public static void main(String[] args) {
        // System.out.println(IsReverse("hello", "olleh"));
        // System.out.println(PairStar("yeeepp"));
        // System.out.println(duplicateRemove("haiiiiiiii"));
        // int[] arr = { -18, 1, 3, 5, -5, 6 };
        // maxSumSubArray(arr);
        // System.out.println(equalize(arr));
	 stringchars("1123", 0,"");
//		countNQueens(8);
//		 printNQueens(4);
//		 System.out.println(getNQueens(4));
//		System.out.println(CountBoardPathWDD(10, 0, 2));
    }

    public static boolean IsReverse(String str1, String str2) {
        if (str1.length() == 0 && str2.length() != 0 || str2.length() == 0 && str1.length() != 0) {
            return false;
        }
        if (str2.length() == 0) {
            return true;
        }
        if (str1.charAt(0) != str2.charAt(str2.length() - 1)) {
            return false;
        }
        String leftstr1 = str1.substring(1);
        String leftstr2 = str2.substring(0, str2.length() - 1);
        Boolean recans = IsReverse(leftstr1, leftstr2);

        return recans;
    }

    public static String PairStar(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }
        String Final = "";
        if (str.charAt(0) == str.charAt(1)) {
            Final += str.charAt(0) + "*";
        } else {
            Final += str.charAt(0);
        }
        str = str.substring(1);
        Final += PairStar(str);
        return Final;
    }

    public static String duplicateRemove(String str) {

        if (str.length() <= 1) {
            return str;
        }
        if (str.charAt(1) == str.charAt(0)) {
            return duplicateRemove(str.substring(1));
        } else {
            return str.charAt(0) + duplicateRemove(str.substring(1));
        }
    }

    public static void maxSumSubArray(int[] arr) {
        if (arr.length == 0) {
            System.out.println("null array.");
            return;
        }
        int LargestSum = arr[0];
        int si = 0, li = 0;
        for (int i = 0; i < arr.length; i++) {
            int sumnow = 0;

            for (int j = i; j < arr.length; j++) {
                sumnow = sumnow + arr[j];

                if (sumnow > LargestSum) {
                    LargestSum = sumnow;
                    si = i;
                    li = j;

                }

            }
        }
        System.out.println(si + "," + li);
    }

    public static int equalize(int[] arr) {
        int count = 0;
        int size = arr.length - 1;
        Lecture8.ArraySorts.bubbleSort(arr);
        Lecture6.ArrayStuff.display(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            while (arr[i] + 5 <= arr[size]) {
                arr[i] += 5;
                count++;
            }
            while (arr[i] + 3 <= arr[size]) {
                arr[i] += 3;
                count++;
            }
            while (arr[i] + 1 <= arr[size]) {
                arr[i] += 1;
                count++;
            }

        }
        return count;
    }

    public static void lexicographicalPrint(int N, int now) {
        if (now <= N) {
            System.out.println(now);
        }
        if (now > N) {
            return;
        }
        if (now == 0) {
            for (int i = 1; i < 10; i++) {
                lexicographicalPrint(N, now * 10 + i);
            }
        } else {
            for (int i = 0; i < 10; i++) {
                lexicographicalPrint(N, now * 10 + i);
            }

        }
    }

    public static void stringchars(String str, int si, String osf) {
        if (si >= str.length()) {
            System.out.println(osf);

            return;
        }
        if (si <= str.length() - 2) {
            int twoch = RecursionStuff.ConvertToNumber(str.substring(si, si + 2));
            if (twoch <= 26) {
                stringchars(str, si + 2, osf + ((char) (twoch + 'a' - 1)));

            }
        }
        int onech = RecursionStuff.ConvertToNumber(str.substring(si, si + 1));
        stringchars(str, si + 1, osf + (char) (onech + 'a' - 1));

    }

    public static void countNQueens(int N) {
        boolean[][] board = new boolean[N][N];
        System.out.println(countNQueens(board, 0));
    }

    public static int countNQueens(boolean[][] board, int row) {
        if (row == board.length) {
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board.length; col++) {
            if (isItSafeTPQ(board, row, col)) {
                board[row][col] = true;
                count = count + countNQueens(board, row + 1);
                board[row][col] = false;

            }
        }
        return count;
    }

    public static boolean isItSafeTPQ(boolean[][] board, int row2check, int col2check) {
        int row, col;
        for (row = row2check - 1; row >= 0; row--) {
            if (board[row][col2check] == true) {
                return false;
            }
        }
        for (row = row2check - 1, col = col2check - 1; col >= 0 && row >= 0; col--, row--) {
            if (board[row][col] == true) {
                return false;
            }
        }
        for (row = row2check - 1, col = col2check + 1; col < board.length && row >= 0; col++, row--) {
            if (board[row][col] == true) {
                return false;
            }

        }
        return true;
    }

    public static void printNQueens(int N) {
        boolean[][] board = new boolean[N][N];
        printNQueens(board, 0, "");
    }

    public static void printNQueens(boolean[][] board, int row, String strnow) {
        if (row == board.length) {
            System.out.println(strnow + "FIN");
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isItSafeTPQ(board, row, col)) {
                board[row][col] = true;
                printNQueens(board, row + 1, strnow + "(" + row + "-" + col + "), ");
                board[row][col] = false;

            }
        }
    }

    public static ArrayList<String> getNQueens(int N) {
        boolean[][] board = new boolean[N][N];
        return getNQueens(board, 0);
    }

    public static ArrayList<String> getNQueens(boolean[][] board, int row) {
        if (row == board.length) {
            ArrayList<String> Last = new ArrayList<String>();
            Last.add("\n");
            return Last;
        }
        ArrayList<String> Final = new ArrayList<String>();
        for (int col = 0; col < board.length; col++) {
            if (isItSafeTPQ(board, row, col)) {
                board[row][col] = true;
                ArrayList<String> RecResult = getNQueens(board, row + 1);
                for (int i = 0; i < RecResult.size(); i++) {
                    Final.add("(" + row + "-" + col + ")" + ";" + RecResult.get(i));
                }
            }
            board[row][col] = false;
        }

        return Final;
    }

    public static int CountBoardPathWDD(int Final, int now, int dice) {
        int times = 0;
        if (now == Final) {
            return 1;
        }
        if (now > Final) {
            return 0;
        }

        for (int i = 1; i <= dice; i++) {
            times = times + CountBoardPathWDD(Final, now + i, dice);
        }

        return times;
    }
}

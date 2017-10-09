package TimeComplexity;

import java.util.ArrayList;

import Lecture11.RecursionStuff;

public class CommonSubsequences {

    public static void main(String[] args) {
        String s1 = "acgdefqwercejcn";
        String s2 = "acdfeqwecklnds";
        // TimeComplexityChecker.init();
        // System.out.println(LCS(s1, s2));
        // System.out.println(TimeComplexityChecker.duration());
        // TimeComplexityChecker.init();
        // System.out.println(LCSBtr(s1, s2, new int
        // [s1.length()+1][s2.length()+1]));
        // System.out.println(TimeComplexityChecker.duration());
        // TimeComplexityChecker.init();
        // System.out.println(editDistanceBTR(s1, s2, new
        // int[s1.length()][s2.length()]));
        // System.out.println(TimeComplexityChecker.duration());
        // TimeComplexityChecker.init();
        // System.out.println(editDistance(s1, s2));
        // System.out.println(TimeComplexityChecker.duration());
        int[] vals = {50, 30, 40, 10};
        int[] wts = {3, 6, 4, 5};
        int TW = 10;
        // TimeComplexityChecker.init();
        // System.out.println(knapSack(vals, wts, TW, 0));
        // System.out.println(TimeComplexityChecker.duration());
        // TimeComplexityChecker.init();
//		System.out.println(knapSackBtr(vals, wts, TW, 0, new int[TW + 1][vals.length]));
        // System.out.println(TimeComplexityChecker.duration());
        System.out.println(printKnapsack(vals, wts, TW, 0, new int[TW + 1][vals.length]));

    }

    public static int CommonSubsequences(String str1, String str2) {

        int highest = 0;
        ArrayList<String> str1sub = new ArrayList();
        ArrayList<String> str2sub = new ArrayList();
        str1sub = RecursionStuff.Subsequences(str1);
        str2sub = RecursionStuff.Subsequences(str2);
        if (str1sub.size() > str2sub.size()) {
            for (int i = 0; i < str2sub.size(); i++) {
                if (str1sub.contains(str2sub.get(i))) {
                    int now = str2sub.get(i).length();
                    if (now > highest) {
                        highest = now;
                    }

                }

            }
        }
        if (str2sub.size() > str1sub.size()) {
            for (int i = 0; i < str1sub.size(); i++) {
                if (str2sub.contains(str1sub.get(i))) {
                    int now = str1sub.get(i).length();
                    if (now > highest) {
                        highest = now;
                    }
                }

            }
        }
        return highest;
    }

    public static int LCS(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        int Final = 0;
        if (str1.charAt(0) == str2.charAt(0)) {
            Final = 1 + LCS(str1.substring(1), str2.substring(1));
        } else {
            int case1 = LCS(str1.substring(1), str2);
            int case2 = LCS(str1, str2.substring(1));
            Final = Math.max(case1, case2);

        }
        return Final;
    }

    public static int LCSBtr(String str1, String str2, int[][] Storage) {
        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }
        if (Storage[str1.length()][str2.length()] != 0) {
            return Storage[str1.length()][str2.length()];
        }
        int Final = 0;
        if (str1.charAt(0) == str2.charAt(0)) {
            Final = 1 + LCSBtr(str1.substring(1), str2.substring(1), Storage);
        } else {

            int case1 = LCSBtr(str1.substring(1), str2, Storage);

            int case2 = LCSBtr(str1, str2.substring(1), Storage);

            Final = Math.max(case1, case2);
            Storage[str1.length()][str2.length()] = Final;

        }

        return Final;
    }

    public static int editDistance(String s1, String s2) {
        if (s1.length() == 0) {
            return s2.length();
        }
        if (s2.length() == 0) {
            return s1.length();
        }
        int Final = 0;
        if (s1.charAt(0) == s2.charAt(0)) {
            Final = editDistance(s1.substring(1), s2.substring(1));
        } else {

            int remED = 1 + editDistance(s1.substring(1), s2.substring(1));
            int delED = 1 + editDistance(s1.substring(1), s2);
            int insED = 1 + editDistance(s1, s2.substring(1));
            Final = Math.min(remED, Math.min(delED, insED));
        }
        return Final;
    }

    public static int editDistanceBTR(String s1, String s2, int[][] Storage) {
        if (s1.length() == 0) {
            return s2.length();
        }
        if (s2.length() == 0) {
            return s1.length();
        }
        int Final = 0;
        if (s1.charAt(0) == s2.charAt(0)) {
            Final = editDistanceBTR(s1.substring(1), s2.substring(1), Storage);
        } else {
            if (Storage[s1.length()][s2.length()] != 0) {
                return Storage[s1.length()][s2.length()];
            }
            int remED = 1 + editDistanceBTR(s1.substring(1), s2.substring(1), Storage);
            int delED = 1 + editDistanceBTR(s1.substring(1), s2, Storage);
            int insED = 1 + editDistanceBTR(s1, s2.substring(1), Storage);
            Final = Math.min(remED, Math.min(delED, insED));
            Storage[s1.length()][s2.length()] = Final;
        }
        return Final;
    }

    public static int knapSack(int[] vals, int[] wts, int TW, int si) {
        if (si == vals.length) {
            return 0;
        }

        int valnow = vals[si];
        int wtnow = wts[si];
        int f1 = 0;
        if (TW - wtnow > 0) {
            f1 = valnow + knapSack(vals, wts, TW - wtnow, si + 1);
        }
        int f2 = knapSack(vals, wts, TW, si + 1);
        return Math.max(f1, f2);

    }

    public static int knapSackBtr(int[] vals, int[] wts, int TW, int si, int[][] Storage) {
        if (si == vals.length) {
            return 0;
        }
        if (Storage[TW][si] != 0) {
            return Storage[TW][si];
        }
        int valnow = vals[si];
        int wtnow = wts[si];
        int f1 = 0, f3 = 0;
        if (TW - wtnow >= 0) {
            f1 = valnow + knapSackBtr(vals, wts, TW - wtnow, si + 1, Storage);
        }
        int f2 = knapSackBtr(vals, wts, TW, si + 1, Storage);
        Storage[TW][si] = Math.max(f1, f2);
        return Math.max(f1, f2);

    }

    public static int knapSackBtrWRepeat(int[] vals, int[] wts, int TW, int si, int[][] Storage) {
        if (si == vals.length) {
            return 0;
        }
        if (Storage[TW][si] != 0) {
            return Storage[TW][si];
        }
        int valnow = vals[si];
        int wtnow = wts[si];
        int f1 = 0, f3 = 0;
        if (TW - wtnow >= 0) {
            f1 = valnow + knapSackBtrWRepeat(vals, wts, TW - wtnow, si + 1, Storage);
            f3 = valnow + knapSackBtrWRepeat(vals, wts, TW - wtnow, si, Storage);
        }
        int f2 = knapSackBtrWRepeat(vals, wts, TW, si + 1, Storage);
        Storage[TW][si] = Math.max(f1, Math.max(f2, f3));
        return Math.max(f1, Math.max(f2, f3));

    }

    public static int printKnapsack(int[] vals, int[] wts, int TW, int si, int[][] Storage) {
        if (si == vals.length) {

            return 0;
        }
        if (Storage[TW][si] != 0) {
            return Storage[TW][si];
        }
        int valnow = vals[si];
        int wtnow = wts[si];
        int f1 = 0, f3 = 0;
        if (TW - wtnow >= 0) {
            f1 = valnow + printKnapsack(vals, wts, TW - wtnow, si + 1, Storage);
            f3 = valnow + printKnapsack(vals, wts, TW - wtnow, si, Storage);
        }
        int f2 = printKnapsack(vals, wts, TW, si + 1, Storage);
        Storage[TW][si] = Math.max(f1, Math.max(f2, f3));
        return Math.max(f1, Math.max(f2, f3));

    }

}

package TimeComplexity;

public class DP {

    public static void main(String[] args) {
        // System.out.println(CountBoardPath(10, 0));
        // System.out.println(CBPBtr2(10, 0)[0]);
        // System.out.println(CBPItr(10, 0));
        System.out.println(CountMazePath(3, 3, 0, 0));
//		System.out.println(CMPItr(3, 3));
        System.out.println(CMPBtr(3, 3));
    }

    public static int FibBtr2(int n, int[] storage) {
        if (n == 1) {
            storage[0] = 1;
            storage[1] = 0;
            return 1;
        }
        int fibnm1 = FibBtr2(n - 1, storage);
        int fibnm2 = storage[1];
        int fibn = fibnm1 + fibnm2;
        storage[1] = storage[0];
        storage[0] = fibn;
        return fibn;
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

    public static int[] CBPBtr2(int Final, int now) {
        if (Final == now) {
            int[] Last = new int[6];
            Last[0] = 1;
            return Last;
        }
        int valnow = 0;
        int[] Recval = CBPBtr2(Final, now + 1);
        for (int i = 5; i >= 0; i--) {
            valnow += Recval[i];
            if (i != 0) {
                Recval[i] = Recval[i - 1];
            }
        }
        Recval[0] = valnow;
        return Recval;

    }

    public static int CBPItr(int Final, int now) {
        int[] arr = new int[6];
        arr[0] = 1;
        for (int i = Final - 1; i >= 0; i--) {
            int valnow = 0;

            for (int j = 5; j >= 0; j--) {
                valnow += arr[j];
                if (j != 0) {
                    arr[j] = arr[j - 1];
                }
            }
            arr[0] = valnow;

        }
        return arr[0];
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

    public static int CMPBtr(int ec, int er) {
        int[] Storage = new int[er + 1];

        for (int i = 0; i <= er; i++) {
            Storage[i] = 1;
        }
        for (int i = 1; i <= ec; i++) {
            for (int j = 1; j <= er; j++) {
                Storage[j] = Storage[j] + Storage[j - 1];

            }
        }
        return Storage[er];
    }

    public static int CMPItr(int er, int ec) {
        int[][] arr = new int[er + 1][+ec + 1];
        arr[er][ec] = 1;
        for (int row = er; row >= 0; row--) {
            for (int col = ec; col >= 0; col--) {
                if (row + 1 <= er) {
                    arr[row][col] += arr[row + 1][col];
                }
                if (col + 1 <= ec) {
                    arr[row][col] += arr[row][col + 1];
                }
            }
        }
        return arr[0][0];

    }

}

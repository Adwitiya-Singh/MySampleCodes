package Lecture6;

import java.util.Scanner;

public class ArrayStuff {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int srch, index = -1;
        // // part 1 INPUT AND DISPLAY
        // int[] arr = takeinput();
        // display(arr);
        // // part 2 LARGEST
        // System.out.println("Largest value in array is " + max(arr));
        // // part 3 LINEAR SEARCH
        // System.out.println("Enter a value to search in the array ");
        // srch = scn.nextInt();
        // index = LinearSearch(arr, srch) + 1;
        // if (index == -1)
        // System.out.println(srch + "is not present in the array");
        // else
        // System.out.println(srch + " is at " + index + "th position in the
        // array");
        // // part 4 REVERSE
        // System.out.println("Enter an array to reverse ");
        // int[] arrtwo = takeinput();
        // System.out.print("The array you intered is ");
        // display(arrtwo);
        // Reverse(arrtwo);
        // System.out.print("The reversed Array is ");
        // display(arrtwo);
        // // part 5 INVERSE
        // System.out.println("Enter an array to find the inverse of ");
        int[] arrthr = takeinput();
        int[] inv = inverse(arrthr);
        System.out.print("The inversed Array is ");
        display(inv);
        // // part 6 CHECK INVERSE
        // System.out.println("Enter an array ");
        // int[] arrfour = takeinput();
        // System.out.println("Enter a second array to see if it's the inverse
        // of the first ");
        // int[] arrfive = takeinput();
        // boolean IsIt = CheckInverse(arrfour, arrfive);
        // if (IsIt) {
        // System.out.println("It is an Inverse!");
        // } else
        // System.out.println("It isn't an Inverse :(");
        // // part 7 CHECK MIRROR INVERSE
        // System.out.println("Enter an array to check if it's a mirror
        // inverse");
        // int arrsix[] = takeinput();
        // boolean mirror = IsMirrorInverse(arrsix);
        // if (mirror) {
        // System.out.println("It is a Mirror inverse!");
        // } else
        // System.out.println("It isn't a Mirror inverse :(");
        // // part 8 BINARY SEARCH
        // System.out.println("Enter a sorted array ");
        // int arrseven[] = takeinput();
        // System.out.print("Enter a number to be searched in the array ");
        // int search = scn.nextInt();
        // int indextwo = BinarySearch(arrseven,search) + 1;
        // if (indextwo == -1)
        // System.out.println(search + "is not present in the array");
        // else
        // System.out.println(search + " is at " + indextwo + "th position in
        // the array");
        // part 9 SUBSETS
        // System.out.println("Enter an array");
        // int[] arreight = takeinput();
        // subsets(arreight);
        // subsets(arreight);
        // part 10
//		int[] arrnine = { 1, 2, 3 };
//		permutations(arrnine);
    }

    public static int[] takeinput() {
        int N;
        int[] retVal = null;
        System.out.println("Enter the size of the array ");
        N = scn.nextInt();
        retVal = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Enter " + i + "th value ");
            retVal[i] = scn.nextInt();

        }
        return retVal;

    }

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("END");
    }

    public static int max(int[] arr) {
        int Largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > Largest)
                Largest = arr[i];
        }
        return Largest;
    }

    public static int LinearSearch(int[] arr, int data) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }

    public static void Reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static int[] inverse(int[] arr) {
        int[] retVal = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            retVal[arr[i]] = i;

        }
        return retVal;

    }

    public static boolean CheckInverse(int[] one, int[] two) {
        boolean Isit = true;
        int[] inv = inverse(one);
        for (int i = 0; i < inv.length; i++) {
            if (inv[i] != two[i])
                return false;

        }

        return Isit;
    }

    public static boolean IsMirrorInverse(int[] one) {
        int[] inv = inverse(one);
        for (int i = 0; i < inv.length; i++) {
            if (inv[i] != one[i])
                return false;

        }
        return true;
    }

    public static int BinarySearch(int[] one, int x) {
        int pos = -1;
        int first = 0;
        int last = one.length - 1;
        int mid = (first + last) / 2;
        while (first <= last) {

            if (one[mid] < x)
                first = mid + 1;
            if (one[mid] == x) {
                pos = mid;
                break;
            }
            if (one[mid] > x)
                last = mid - 1;
            mid = (first + last) / 2;
        }
        return pos;
    }

    public static void subsets(int[] set) {
        int n = set.length;
        for (int i = 0; i < (1 << n)/* Math.pow(2,n) */; i++) {
            System.out.print("{ ");

            for (int j = 0; j < n; j++)

                if ((i & 1 << j) > 0)
                    System.out.print(set[j] + " ");

            System.out.println("}");
        }
    }

    public static void subsequence(int[] set) {
        int counter;
        for (int i = 0; i < Math.pow(2, set.length); i++) {
            counter = 0;
            System.out.print("{");
            int num = i;
            while (num > 0) {
                if (num % 2 == 1) {
                    System.out.print(set[counter] + " ");

                }
                counter++;
                num = num / 2;
            }
            System.out.println("}");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void permutations(int[] input) {

        int size = input.length;
        int[] p = new int[size];
        int i = 1;
        for (int x = 0; x < size; x++) {
            System.out.print(input[x]);
        }
        System.out.println();
        while (i < size) {
            if (p[i] < i) {
                int j = 0;
                if (i % 2 != 0) {
                    j = p[i];
                }
                swap(input, i, j);
                for (int x = 0; x < size; x++) {
                    System.out.print(input[x]);

                }
                System.out.println();
                p[i]++;
                i = 1;
            } else {
                p[i] = 0;
                i++;

            }
        }
    }
}

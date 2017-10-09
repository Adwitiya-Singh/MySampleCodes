package SegmentTree;


import java.util.Scanner;

/**
 * Created by adwitiyasingh on 3/17/17.
 */
public class segmentTree {
    private int[] Tree;
    private int[] Lazy;

    public segmentTree(int[] arr) {
        Scanner charscn = new Scanner(System.in);
        Scanner intscn = new Scanner(System.in);
        Tree = new int[(arr.length * 4) + 1];
        buildtree(arr, 1, 0, arr.length - 1);
        char cont = 'y';
        while (cont != 'e') {
            System.out.println();
            System.out.println();
            System.out.println("Press q for a query");
            System.out.println("Press n to update node");
            System.out.println("Press r to update range");
            System.out.println("Press ei to exit");
            cont = charscn.nextLine().charAt(0);
            switch (cont) {
                case 'q': {
                    int qs, qe;
                    System.out.println("Enter query start");
                    qs = intscn.nextInt();
                    System.out.println("Enter query end");
                    qe = intscn.nextInt();
                    System.out.println("Min value is " + queryRangeLazy(1, 0, arr.length - 1, qs, qe));
                    break;
                }
                case 'n': {
                    int ind, inc;
                    System.out.println("Enter index to increment");
                    ind = intscn.nextInt();
                    System.out.println("Enter increment value");
                    inc = intscn.nextInt();
                    updateNode(1, 0, arr.length - 1, ind, inc);
                    break;
                }
                case 'r': {
                    int rs, re, inc;
                    System.out.println("Enter  range start");
                    rs = intscn.nextInt();
                    System.out.println("Enter  range end");
                    re = intscn.nextInt();
                    System.out.println("Enter increment value");
                    inc = intscn.nextInt();
                    updateRangeLazy(1, 0, arr.length - 1, rs, re, inc);
                    break;
                }
                case 'e': {
                    break;
                }
                default: {
                    System.out.println("Wrong input!");
                }


            }

        }

    }

    private void buildtree(int[] arr, int index, int si, int ei) {
        if (si > ei) {
            return;
        }
        if (si == ei) {
            Tree[index] = arr[si];
            return;
        }
        int mid = (si + ei) / 2;
        buildtree(arr, 2 * index, si, mid);
        buildtree(arr, 2 * index + 1, mid + 1, ei);
        Tree[index] = Math.min(Tree[2 * index], Tree[2 * index + 1]);

    }

    private int query(int index, int si, int ei, int qs, int qe) {
        ///No Overlap
        if (qs > ei || qe < si) {
            return Integer.MAX_VALUE;
        }
        ///Complete Overlap
        if (qs <= si && qe >= ei) {
            return Tree[index];
        }

        ///Partial Overlap
        int mid = (si + ei) / 2;
        int leftAns = query(2 * index, si, mid, qs, qe);
        int rightAns = query(2 * index + 1, mid + 1, ei, qs, qe);

        return Math.min(leftAns, rightAns);
    }

    private int queryRangeLazy(int index, int si, int ei, int rs, int re) {
        /// Make pending updates, resolve Lazy value first

        if (Lazy[index] != 0) {
            Tree[index] += Lazy[index];
            if (si != ei) {
                Lazy[2 * index] += Lazy[index];
                Lazy[2 * index + 1] += Lazy[index];
            }
            Lazy[index] = 0;

        }

        ///No Overlap
        if (re < si || rs > ei) {
            return Integer.MAX_VALUE;
        }
        ///Complete Overlap
        if (si >= rs && ei <= re) {

            return Tree[index];
        }
        ///Partial Overlap
        int mid = (si + ei) / 2;
        int left = queryRangeLazy(2 * index, si, mid, rs, re);
        int right = queryRangeLazy(2 * index + 1, mid + 1, ei, rs, re);
        return Math.min(left, right);
    }


    private void updateNode(int index, int si, int ei, int i, int inc) {
        if (i < si || i > ei) {
            return;
        }
        if (si == ei) {
            Tree[index] += inc;
            return;
        }
        /// i is lying in the range si to ei
        int mid = (si + ei) / 2;
        updateNode(2 * index, si, mid, i, inc);
        updateNode(2 * index + 1, mid + 1, ei, i, inc);
        Tree[index] = Math.min(Tree[2 * index], Tree[2 * index + 1]);
        return;
    }

    private void updateRange(int index, int si, int ei, int rs, int re, int inc) {
        ///No Overlap
        if (re < si || rs > ei) {
            return;
        }
        ///Leaf Node
        if (si == ei) {

            Tree[index] += inc;
            return;
        }
        int mid = (si + ei) / 2;
        updateRange(2 * index, si, mid, rs, re, inc);
        updateRange(2 * index + 1, mid + 1, ei, rs, re, inc);
        Tree[index] = Math.min(Tree[2 * index], Tree[2 * index + 1]);
        return;
    }

    private void updateRangeLazy(int index, int si, int ei, int rs, int re, int inc) {
        /// Make pending updates, resolve Lazy value first

        if (Lazy[index] != 0) {
            Tree[index] += Lazy[index];
            if (si != ei) {
                Lazy[2 * index] += Lazy[index];
                Lazy[2 * index + 1] += Lazy[index];
            }
            Lazy[index] = 0;

        }
        ///No Overlap
        if (re < si || rs > ei) {
            return;
        }
        ///Complete Overlap
        if (si >= rs && ei <= re) {
            Tree[index] += inc;
            if (si != ei) {
                Lazy[2 * index] += inc;
                Lazy[2 * index + 1] += inc;

            }
            return;
        }
        ///Partial Overlap
        int mid = (si + ei) / 2;
        updateRangeLazy(2 * index, si, mid, rs, re, inc);
        updateRangeLazy(2 * index + 1, mid + 1, ei, rs, re, inc);
        Tree[index] = Math.min(Tree[2 * index], Tree[2 * index + 1]);
        return;
    }
}


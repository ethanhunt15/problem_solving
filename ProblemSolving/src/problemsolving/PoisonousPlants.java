package problemsolving;

import java.io.*;
import java.util.*;

public class PoisonousPlants {

	public static void main(String[] args) {
		
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

//		Scanner in = new Scanner(System.in);
//		int testCases = in.nextInt(); // number of test cases
//		ArrayList<Integer> treeInputList = new ArrayList<>();
//
//		for (int i = 0; i < testCases; i++) {// each test case
//			treeInputList.add(in.nextInt());
//		}
//		in.close();
//
//		int noOfDays = 0; //to keep track of number of days
//		boolean isNextDayRequired = true;
//		while (isNextDayRequired) {
//			//Set this false now, since we are already inside loop for this day
//			isNextDayRequired = false; 
//			ArrayList<Integer> removedTreeIndex = new ArrayList<>();
//			for (int j = 1; j < treeInputList.size() && treeInputList.size() > 1; j++) {
//				if (treeInputList.get(j - 1) < treeInputList.get(j)) {
//					isNextDayRequired = true;
//					removedTreeIndex.add(j);
//				}
//			}
//
//			if (removedTreeIndex.size() >= 1) {
//				noOfDays++;
//			}
//
//			Collections.sort(removedTreeIndex, Collections.reverseOrder());
//			for (int i : removedTreeIndex)
//			{
//				treeInputList.remove(i);
//			}	
//		}
//		System.out.println(noOfDays);
		
		  Scanner sc = new Scanner(System.in);
          int N = sc.nextInt();

          int[] a = new int[N];

          for (int i = 0; i < a.length; i++) {
                  a[i] = sc.nextInt();
          }

          System.out.println(process(a));
	}
	public static int process(int[] a) {

        Stk A = new Stk(a.length);

        int max = 0;

        A.push(0);

        int[] k = new int[a.length];
        int[] d = new int[a.length];

        k[0] = -1;
        for (int i = 1; i < a.length; i++) {

                if (a[A.peep()] < a[i]) {

                        k[i] = A.peep();

                        d[i] = 1;

                } else if (a[A.peep()] == a[i]) {

                        k[i] = k[A.peep()];

                        if (k[i] != -1)
                                d[i] = d[A.peep()] + 1;
                        else
                                d[i] = d[A.peep()];

                } else if (a[A.peep()] > a[i]) {

                        while (A.getCurrentPointer() != -1 && a[A.peep()] > a[i]) {
                                A.pop();
                        }
                        if (A.getCurrentPointer() == -1) {
                                k[i] = -1;
                        } else if (a[A.peep()] == a[i]) {

                                k[i] = k[A.peep()];
                                if (k[i] != -1) {

                                        d[i] = getMax(d, k[i] + 1, i - 1) + 1;
                                } else
                                        d[i] = d[A.peep()] + 1;

                        } else {
                                k[i] = A.peep();

                                d[i] = getMax(d, k[i] + 1, i - 1) + 1;

                        }

                }
                A.push(i);
                if (max < d[i])
                        max = d[i];
        }

        return max;
}

public static int getMax(int[] maxK, int start, int end) {

        int max = 0;
        for (int i = start; i <= end; i++) {
                int c = maxK[i];
                if (c > max)
                        max = c;
        }
        return max;
}

}

class Stk {

private int[] stkArr = null;

private static int[] stkMaxArr = null;

private static int maxPointer = 0;

private int currentPointer = -1;

private int size = 0;

private int total = 0;

public Stk(int size) {
        super();
        this.size = size;
        stkArr = new int[size];
}

public void push(int x) {
        currentPointer++;
        stkArr[currentPointer] = x;

        total = total + x;

}

public int getTotal() {
        return total;
}

public int pop() {
        int val = stkArr[currentPointer];
        stkArr[currentPointer] = 0;
        currentPointer--;

        total = total - val;

        return val;

}

public int peep() {
        if (currentPointer > -1)
                return stkArr[currentPointer];
        else
                return -99;
}

public int getCurrentPointer() {
        return currentPointer;
}

public int getSize() {
        return size;
}

public int getMax() {
        return stkMaxArr[maxPointer];
}
}
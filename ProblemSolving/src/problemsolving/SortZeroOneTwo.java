package problemsolving;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Write a program to sort an array of 0's,1's and 2's in ascending order.

Input:
The first line contains an integer 'T' denoting the total number of test cases. In each test cases, First line is number of elements in array 'N' and second its values.

Output: 
Print the sorted array of 0's, 1's and 2's.

Constraints: 

1 <= T <= 100
1 <= N <= 100
0 <= arr[i] <= 2

Example:

Input :

2
5
0 2 1 2 0
3
0 1 0


Output:

0 0 1 2 2
0 0 1
 */

public class SortZeroOneTwo {

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner (System.in);
		int noOfElement = scanner.nextInt();
		ArrayList<Integer> inputList = new ArrayList<>();
		for(int i=0;i<noOfElement;i++)
		{
			inputList.add(scanner.nextInt());	
		}

		SortZeroOneTwo sot = new SortZeroOneTwo();
		ArrayList<Integer> sortedList = sot.sortArray(inputList);
	}

	public ArrayList<Integer> sortArray(ArrayList<Integer> inputList)
	{
		ArrayList<Integer> sortedList = new ArrayList<>();
		int low = 0;
		int high =  inputList.size() -1;
		int mid = (low + high)/2;

		while(mid <= high)
		{
			switch(inputList.get(mid))
			{
			case 0:

				break;

			case 1:
				break;

			case 2:
				break;
			}
		}

		return sortedList;
	}

	// Sort the input array, the array is assumed to
	// have values in {0, 1, 2}
	static void sort012(int a[], int arr_size)
	{
		int lo = 0;
		int hi = arr_size - 1;
		int mid = 0,temp=0;
		while (mid <= hi)
		{
			switch (a[mid])
			{
			case 0:
			{
				temp   =  a[lo];
				a[lo]  = a[mid];
				a[mid] = temp;
				lo++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2:
			{
				temp = a[mid];
				a[mid] = a[hi];
				a[hi] = temp;
				hi--;
				break;
			}
			}
		}
	}

}//end class

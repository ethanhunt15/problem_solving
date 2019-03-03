package problemsolving;

import java.util.Scanner;

/*
Given an array containing both negative and positive integers. 
Find the contiguous sub-array with maximum sum.

Input:
The first line of input contains an integer T denoting the number of test cases. 
The description of T test cases follows. The first line of each test case contains a 
single integer N denoting the size of array. The second line contains N space-separated 
integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 1000
-100 ≤ A[i] <= 100

Example:
Input
2
3
1 2 3
4
-1 -2 -3 -4
Output
6
-1

 */

public class KadanesAlgorithm {

	public static void main(String[] args)
	{
		KadanesAlgorithm ka = new KadanesAlgorithm();
		Scanner scanner = new Scanner(System.in);
		int noOfTestCases = scanner.nextInt();
		int arrayLength = scanner.nextInt();

		int[] inputArray = new int[arrayLength];
		int i = 0;
		while(i < arrayLength)
		{
			inputArray[i] = scanner.nextInt();
			i++;
		}

		System.out.println(ka.maxSum(inputArray));
	}

	private int maxSum(int[] inputArray)
	{
		int maxSoFar = 0;
		int maxEndingHere = 0;

		for(int i=0; i<inputArray.length;i++)
		{
			maxEndingHere = maxEndingHere + inputArray[i];
			if(maxEndingHere < 0)
			{
				maxEndingHere = 0;
			}

			if(maxSoFar < maxEndingHere)
			{
				maxSoFar = maxEndingHere;
			}
		}

		return maxSoFar;
	}

}//end class

package problemsolving;

import java.util.HashMap;
import java.util.Scanner;

//Given an array A[] of n numbers and another number x, determine whether or not there exist two elements in A whose sum is exactly x.
//
//Input:
//
//The first line of input contains an integer T denoting the number of test cases.
//The first line of each test case is N and X,N is the size of array.
//The second line of each test case contains N integers representing array elements C[i].
//
//Output:
//
//Print "Yes" if there exist two elements in A whose sum is exactly x, else "No" without quotes.
//
//Constraints:
//
//1 ≤ T ≤ 200
//1 ≤ N ≤ 200
//1 ≤ C[i] ≤ 1000
//
//Example:
//
//Input:
//2
//6 16
//1 4 45 6 10 8
//5 10
//1 2 4 3 6
//
//Output:
//Yes
//Yes


public class KeyPair {
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int noOfTestCases = scanner.nextInt();
		int i = 0;
		int arrayOne[] = null;
		int noToBeFound = 0;
		while(i < noOfTestCases)
		{
			int arrayLength = scanner.nextInt();
			noToBeFound = scanner.nextInt();
			int j = 0;
			arrayOne = new int[arrayLength];
			while(j < arrayLength)
			{
				arrayOne[j] = scanner.nextInt();
				j++;
			}
			
			i++;
		}
		KeyPair kp = new KeyPair();
		System.out.println(kp.isKeyPair(arrayOne,noToBeFound));
		
	}

	public String isKeyPair(int inputArray[], int searchedNo )
	{
		HashMap<Integer,Integer> inputMap = new HashMap<>();
		for(int i=0; i<inputArray.length;i++)
		{
			if(inputMap.get(inputArray[i]) != null)
			{
				if(inputMap.get(inputArray[i]) == 1)
				{
					return "Yes";
				}	
			}
			else
			{
				inputMap.put(searchedNo - inputArray[i], 1);	
			}
		}
		
		return "No";
	}
}//end class
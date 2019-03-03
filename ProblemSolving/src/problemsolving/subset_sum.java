package problemsolving;

public class subset_sum {
 // Returns true if there is a subset of set[] with sun equal to given sum
 static boolean isSubsetSum(int inputSet[], int n, int sum)
 {
     // The value of subset[i][j] will be true if there 
         // is a subset of set[0..j-1] with sum equal to i
     boolean subset[][] = new boolean[n+1][sum+1];
   
     // If sum is 0, then answer is true
     for (int row = 0; row <= n; row++)
       subset[row][0] = true;
   
     // If sum is not 0 and set is empty, then answer is false
     for (int col = 1; col <= sum; col++)
       subset[0][col] = false;
   
      // Fill the subset table in bottom up manner
      for (int i = 1; i <= n; i++)
      {
        for (int j = 1; j <= sum; j++)
        {
        	if(j < inputSet[i-1])
        	{
        		subset[i][j] = subset[i-1][j];	
        	}
          
          if (j >= inputSet[i-1])
          {
            subset[i][j] = subset[i-1][j] || subset[i - 1] [j - inputSet[i-1]];
          }
        }
      }
   
      // uncomment this code to print table
      for (int i = 0; i <= n; i++)
      {
        for (int j = 0; j <= sum; j++)
           System.out.println (subset[i][j]);
      } 
   
      return subset[n][sum];
 }
 /* Driver program to test above function */
 public static void main (String args[])
 {
       int set[] = {3, 34, 4, 12, 5, 2};
       int sum = 1;
       int n = set.length;
       if (isSubsetSum(set, n, sum) == true)
          System.out.println("Found a subset with given sum");
       else
          System.out.println("No subset with given sum");
 }
}
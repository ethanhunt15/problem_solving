package problemsolving;
/*The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence 
 * of a given sequence such that all elements of the subsequence are sorted in increasing order. 
 * For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and 
 * LIS is {10, 22, 33, 50, 60, 80}.
 * 
 */

public class Lis {
		
	public static void main(String[] args)
	{
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        Lis l = new Lis();
        System.out.println("Length of lis is " + l.getLis( arr, n ) + "n" );
	}
	
	public int getLis(int arr[], int n)
	{
		int lis[] = new int[n];
        int i,j,max = 0;
        
        for(i=0;i<n;i++)
        {
        	lis[i] = 1;
        }
        
        for(i=1;i<n;i++){
        	for(j=0;j<i;j++)
        	{
        		if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
        	}
        }
        
        for(i=0; i<n;i++)
        {
        	if(lis[i] > max)
        	{
        		max = lis[i];
        	}
        }
        
		return max;
	}

}

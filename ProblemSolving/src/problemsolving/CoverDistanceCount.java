package problemsolving;

public class CoverDistanceCount
{
    // Function returns count of ways to cover 'dist'
    static int printCountDP(int dist)
    {
//        int[] count = new int[dist+1];
//  
//        // Initialize base values. There is one way to 
//        // cover 0 and 1 distances and two ways to 
//        // cover 2 distance
//        count[0] = 1;
//        count[1] = 1;
//        count[2] = 2;
//  
//        // Fill the count array in bottom up manner
//        for (int i=3; i<=dist; i++)
//            count[i] = count[i-1] + count[i-2] + count[i-3];
//  
//        return count[dist];
    	
    	int[] stepsArr = {1,2,3};
    	int arrSize = stepsArr.length;
    	int[] solution = new int[dist + 1];
    	solution[0] = 1;
    	for( int i=0; i<3; i++)
    	    for(int j=stepsArr[i]; j<= dist; j++)
    	       {
    	          solution[j] +=  solution[ j- stepsArr[i]];
    	        }
    	return solution[dist];
    }
     
    // driver program
    public static void main (String[] args) 
    {
        int dist = 4;
        System.out.println(printCountDP(dist));
    }
}
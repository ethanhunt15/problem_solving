package problemsolving;
/*
 * Given two sequences, find the length of longest subsequence present in both of them. 
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 * */

public class Lcs {
	
	public static void main(String[] args)
	{
		Lcs l = new Lcs();
		String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";
	 
	    char[] X=s1.toCharArray();
	    char[] Y=s2.toCharArray();
	    int m = X.length;
	    int n = Y.length;
	 
	    System.out.println("Length of LCS is" + " " +
	                                  l.lcs( X, Y, m, n ) );
	}

	int lcs(char[] str1,char[]str2,int lenStr1, int lenStr2)
	{
		
		int lcsLen[][] = new int[lenStr1+1][lenStr2+1];
		for(int i=0; i <=lenStr1; i++)
			for(int j=0;j<=lenStr2;j++)
			{
				if(i==0 || j==0)
				{
					lcsLen[i][j] = 0;
				}
				else if(str1[i-1] == str2[j-1])
					lcsLen[i][j] = 1 + lcsLen[i-1][j-1];
				
				else
					lcsLen[i][j] = max(lcsLen[i-1][j],lcsLen[i][j-1]);
					
			}
		return lcsLen[lenStr1][lenStr2];
	}
	
	int max(int a, int b)
	{
		return a > b ? a : b;
	}
}

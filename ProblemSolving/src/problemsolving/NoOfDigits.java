package problemsolving;

/*
 * Count the number of digits in a long integer entered by a user.
 * Input: 835113
 * Output: 6
 * 
 */

public class NoOfDigits {
	
	public static void main(String[] args)
	{
		NoOfDigits nod = new NoOfDigits();
		System.out.println(nod.getNoOfDigits(110));
	}

	
	public int getNoOfDigits(int n)
	{
		if (n == 0)
	        return 0;
	    return 1 + getNoOfDigits(n / 10);
	}
}

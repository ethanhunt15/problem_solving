package problemsolving;

public class SetBits {
	
	public static void main(String[] args)
	{
		System.out.println("Set Bits:: " + getSetBits(14));
		System.out.println("Parity:: " + parityVer2(14));
		//77	1001101
		System.out.println("swapbits::" +swapbits(77,2,4));
	}
	
	public static int getSetBits(int n)
	{
		int setBitsCount = 0;
		while(n > 0)
		{
			if((n & 1) == 1 )
			{
				setBitsCount++;	
			}
			n = n/2;
		}
		
		return setBitsCount;
	}
	
	public static short parity(long x)
	{ 
		short result = 0;
	
	while (x != 0) {
	result ^=(x&1);
	x >>>= 1;
	}
	return result;
	
	}
	
	public static short parityVer2(long x){ 
		
	x ^= x >>> 32;
	x ^= x >>> 16;
	x ^= x >>> 8;
	x ^= x >>> 4; 
	x ^= x >>> 2; 
	x ^= x >>> 1;
	return (short)(x & 1);
	}
	
	public static long swapbits(long x, int i, int j)
	{
		System.out.println("Orignal Bits:: " + Long.toString(x,2));
		// Extract the i-th and j-th bits, and see if they differ. 
		if (((x >>> i) & 1) != ((x >>> j) & 1))
		{
		// i-th and j-th bits differ. We will swap them by flipping their values. // Select the bits to flip with bitMask. Since xAl = <9 when x = 1 and 1
		// when x = (9, we can perform the flip XOR .
			System.out.println("First Mask Bits:: " + Long.toString(1L << i,2));
			System.out.println("Second Mask Bits:: " + Long.toString(1L << j,2));
		long bitMask = (1L << i) | (1L << j);
		System.out.println("Final Mask Bits:: " + Long.toString(bitMask,2));
		x ^= bitMask;
		}
		System.out.println("Swapped Bits:: " + Long.toString(x,2));
		return x;
		
		//System.out.println(Integer.toBinaryString(343));
		//Integer.toString(100,2) 
	}
}//End class

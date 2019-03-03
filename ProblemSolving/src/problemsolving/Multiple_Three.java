package problemsolving;

import java.util.Scanner;

public class Multiple_Three {
	public static void main(String[] args)
	{
		Multiple_Three mm = new Multiple_Three();
		Scanner scanner = new Scanner(System. in); 
		int input = scanner.nextInt();
		String binaryNumbers[] = new String[input];
		int i = 0;
		while(i < input)
		{
			binaryNumbers[i] = scanner.next();	
			i++;
		}

		for(int ii=0 ; ii < binaryNumbers.length;ii++)
		{
			System.out.println(mm.isMultipleOfThree(binaryNumbers[ii]));
		}

		

	}
	
	public int isMultipleOfThree(String number)
	{
		int evenSetBit = 0;
		int oddSetBit = 0;
		for(int i=0; i< number.length();i++)
		{
			if(number.charAt(i) == '1')
			{
				if(i%2 ==0)
				{
					evenSetBit++;	
				}
				else
				{
					oddSetBit++;
				}
			}
		}
		
		System.out.println("Even Bits: " + evenSetBit);
		System.out.println("Odd Bits: " + oddSetBit);
		if((float)(evenSetBit - oddSetBit) /3 == 0)
			return 1;
		else
			return 0;
	}
}//end class

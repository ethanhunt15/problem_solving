package problemsolving;

public class StringPermutation {

	public static void main(String[] args)
	{
		String str1 = "axba";
		String str2 = "aabb";

		System.out.println("permutation " + permutation(str1,str2));
	}


	static boolean permutation(String source, String test)
	{
		if(source.length() != test.length())
			return false;

		int[] letters = new int[128]; //Assuming ASCII
		char[] source_array = source.toCharArray();
		for(char c : source_array){
			letters[c]++;
		}

		for(int i=0; i< test.length();i++)
		{
			int c = (int) test.charAt(i);
			letters[c]--;
			if(letters[c] < 0)
			{
				return false;
			}
		}
		return true;
	}


}

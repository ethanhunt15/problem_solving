package problemsolving;

public class CoinChange {
	
	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		int[] coins = {1,3,4};
		
		long startTime = System.currentTimeMillis();
		System.out.println("Start Time: " + System.currentTimeMillis());
		//System.out.println(cc.coinRequiredRecur(950,coins));
		System.out.println(cc.coinRequired(950,coins));
		
		long endTime = System.currentTimeMillis();
		long runTime = endTime - startTime;
		System.out.println("Total run Time: " + runTime + " msec");
	}

	public int coinRequired(int money, int[] coins)
	{
		int[] minNoCoins = new int[money+1];
		minNoCoins[0] = 0;
		
		for(int m=1; m< money+1 ; m++)
		{
			minNoCoins[m] = Integer.MAX_VALUE;
			
			for(int j=0; j<coins.length;j++)
			
			if(m >= coins[j])
			{
				int numCoins = minNoCoins[m - coins[j]] + 1;
				if(numCoins  < minNoCoins[m])
				{
					minNoCoins[m] = numCoins;
				}
			}
				
		}
		return minNoCoins[money];
	}
	
	public int coinRequiredRecur(int money, int[] coins)
	{
		if (money == 0)
			return 0;
		int minNoCoins = Integer.MAX_VALUE;
		for(int i=0; i<coins.length ; i++)
		{
			if(money >= coins[i])
			{
				int numCoins = coinRequiredRecur(money -coins[i],coins );
				if((numCoins + 1) < minNoCoins)
				{
					minNoCoins= numCoins + 1;
				}
			}
				
		}
		return minNoCoins;
	}
}

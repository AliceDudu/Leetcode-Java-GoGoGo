public class Solution{
	public int maxProfit( int[] prices ){
		int firstBuy = Integer.MIN_VALUE;
		int firstSell = 0;
		int secondBuy = Integer.MIN_VALUE;
		int secondSell = 0;
		
		for ( int curPrice : prices ){
			if ( firstBuy < -curPrice ){
				firstBuy = -curPrice;
			}
			if ( firstSell < firstBuy + curPrice ){
				firstSell = firstBuy + curPrice;
			}
			if ( secondBuy < firstSell - curPrice ){
				secondBuy = firstSell - curPrice;
			}
			if ( secondSell < secondBuy + curPrice ){
				secondSell = secondBuy + curPrice;
			}
		}
		
		return secondSell;
	}
}
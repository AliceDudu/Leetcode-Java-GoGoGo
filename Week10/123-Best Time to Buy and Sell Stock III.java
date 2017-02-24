

如果只有一次交易的话，
buy的时候，花钱越少越好，
所以，起初有0元，花钱就用负数，所以比较firstBuy < 0 -curPrice，后者越大，说明花钱越少

firstBuy + curPrice就是一次卖－次买的差价，要track记录最大的差价

firstSell - curPrice第一次成交后剩下手里的钱firstSell，再花钱curPrice，保留现在手头剩下最多的钱

secondBuy是现在手里剩的最多的钱，再卖掉curPrice 挣到了curPrice ，保留最多可以剩下多少，就是结果

所以，这四个变量的意义，都是当前操作后，手里能剩下的最多的钱是多少
而它们的计算公式，就是等于if条件的后者，
这四个变量只需要去track最大并自更新

//top sol: 2ms Java DP Solution

public class Solution{
	public int maxProfit( int[] prices ){
		int firstBuy = Integer.MIN_VALUE;
		int firstSell = 0;
		int secondBuy = Integer.MIN_VALUE;
		int secondSell = 0;
		
		for ( int curPrice : prices ){
			if ( firstBuy < 0 -curPrice ){				起初有0元，花钱就用负数，所以比较firstBuy < 0 -curPrice，后者越大，说明花钱越少
				firstBuy = -curPrice;
			}
			if ( firstSell < firstBuy + curPrice ){		firstBuy + curPrice就是一次卖－次买的差价，记录最大的差价
				firstSell = firstBuy + curPrice;
			}
			
			
			if ( secondBuy < firstSell - curPrice ){	firstSell - curPrice第一次成交后剩下手里的钱firstSell，再花钱curPrice，保留现在手头剩下最多的钱
				secondBuy = firstSell - curPrice;
			}
			if ( secondSell < secondBuy + curPrice ){	secondBuy是现在手里剩的最多的钱，再卖掉curPrice 挣到了curPrice ，保留最多可以剩下多少，就是结果
				secondSell = secondBuy + curPrice;
			}
		}
		
		return secondSell;
	}
}

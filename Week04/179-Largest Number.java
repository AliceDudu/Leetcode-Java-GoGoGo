

排序方法不是普通的升序或者降序，因为9要排在最前面，而9既不是数组中最大的也不是最小的，
所以我们要自定义排序方法。
implement a String comparator to decide which String should come first during concatenation.
对于两个数字a和b来说，如果将其都转为字符串，如果ab > ba，则a排在前面，
比如9和34，由于934>349，所以9排在前面

i从左扫到右，遇到两个数字后，先比较一下两种组合的方式，谁大就用哪种组合，并把相应的二者顺序排好
得到的结果作为一个整体，和后面的继续沿用上面的步骤
最后从这样的顺序的s——num里取出来，并且append到string上



public class Solution {
     public String largestNumber(int[] num) {
		if(num == null || num.length == 0)
		    return "";
		
		// Convert int array to String array, so we can sort later on
		String[] s_num = new String[num.length];
		for(int i = 0; i < num.length; i++)
		    s_num[i] = String.valueOf(num[i]);
			
		// Comparator to decide which string should come first in concatenation
		Comparator<String> comp = new Comparator<String>(){
		    @Override
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1); // reverse order here, so we can do append() later
		    }		//大的在前面？返回大的是s2么？
	    };
		
		Arrays.sort(s_num, comp);
                // An extreme edge case by lc, say you have only a bunch of 0 in your int array
                if( s_num[0].charAt(0) == '0' )
                    return "0";
            
		StringBuilder sb = new StringBuilder();
		for( String s: s_num )
	            sb.append(s);
		
		return sb.toString();
		
	}
}


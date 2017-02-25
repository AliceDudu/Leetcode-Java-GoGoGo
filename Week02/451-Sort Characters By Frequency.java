

s从头扫
用一个map记录它，value是它出现的次数

用max是来记录s中最高的频率数
然后建立一个bucket，长度为max＋1
意义是，每个角标对应的字母，就是出现了角标次数的字母

最后扫一遍bucket，从后向前扫
每个角标上的字母，一个一个取出来，每个取出来后都加入到result里角标次

最后得到一个整体就是答案

public class Solution {
    public String frequencySort(String s) {
    
        if( s.length() < 3 )
            return s;
            
        int max = 0;
        int[] map = new int[256];
        
//         s从头扫
// 		用一个map记录它，value是它出现的次数
// 		用max是来记录s中最高的频率数
        for( char ch : s.toCharArray() ) {
            map[ch]++;
            max = Math.max(max, map[ch]);
        }
        
//         意义是，每个角标对应的字母，就是出现了角标次数的字母
        String[] buckets = new String[max + 1]; // create max buckets
        
        for(int i = 0 ; i < 256; i++) { // join chars in the same bucket
            String str = buckets[map[i]];
            
            if(map[i] > 0)
                buckets[map[i]] = (str == null) ? "" + (char)i : (str + (char) i);
        }
        
        StringBuilder strb = new StringBuilder();
        

// 		最后扫一遍bucket，从后向前扫
        for( int i = max; i >= 0; i-- ) { // create string for each bucket.
            if( buckets[i] != null )
//         每个角标上的字母，一个一个取出来，每个取出来后都加入到result里角标次            
                for( char ch : buckets[i].toCharArray() )
//                 每个取出来后都加入到result里角标次  
                    for(int j = 0; j < i; j++)
                        strb.append(ch);
        }
        
//         最后得到一个整体就是答案
        return strb.toString();
    }
}

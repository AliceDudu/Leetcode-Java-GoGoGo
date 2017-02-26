

Example: "xxxbcbxxxxxa", (x is random character, not all x are equal) now we 
          are dealing with the last character 'a'. The current longest palindrome
          is "bcb" with length 3.
1. check "xxxxa" so if it is palindrome we could get a new palindrome of length 5.
2. check "xxxa" so if it is palindrome we could get a new palindrome of length 4.
3. do NOT check "xxa" or any shorter string since the length of the new string is 
   no bigger than current longest length.
4. do NOT check "xxxxxa" or any longer string because if "xxxxxa" is palindrome 
   then "xxxx" got  from cutting off the head and tail is also palindrom. It has 
   length > 3 which is impossible.'
   
public class Solution {
    public String longestPalindrome(String s) {
        
//         res记录最新的回文子集
        String res = "";
        
//         curlen是res的长度，即目前为止最长的
        int currLength = 0;
        
        for( int i = 0; i < s.length(); i++){
        
//         	i - currLength - 1 到 i，走到i时，中间隔了目前最长的curlen个，再－1就是那个head
// 			看新加入的i与隔curlen个的前一位作为尾和首，是否可以构成新的回文
            if( isPalindrome(s, i - currLength - 1, i)){
                res = s.substring(i - currLength - 1, i + 1);
                currLength = currLength + 2;
            
//             i - currLength 到 i 如果可以回文，则比目前的curlen长了一个，所以curlen需要＋1
            }else if( isPalindrome(s, i - currLength, i) ){
                res = s.substring(i - currLength, i + 1);
                currLength = currLength + 1;
            }
        }
        
        return res;
    }
    
//     判断begin到end这一段，是否是Palindrome
    public boolean isPalindrome(String s, int begin, int end){
        if( begin < 0) {
        	return false;
        }
        while( begin < end ){
        	if( s.charAt(begin++) != s.charAt(end--) ) {
        		return false;
        	}
        }
        
        return true;
    }
}
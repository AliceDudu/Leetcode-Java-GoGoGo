

dp意义：s到i和p到j这两段是否匹配
初始化：p和空匹配一下，遇到一个＊，就可以忽略它以及它的前一位，相当于[i + 1]＝[i - 1]
递推公式：
当遇到 .，＊，相等，这三种情况时，是需要考虑约分的
遇到点，可以代表任意字母，所以就相当于s和p中都删掉一个字符，所以 dp[i + 1][j + 1] = dp[i][j]
这两个相等，相当于可以同时删除掉
遇到＊时
在下面这个if的条件时，相当于＊没有起到任何作用，所以可以忽略掉＊及其前面的一位，所以[j + 1]＝[j - 1]
当p.charAt(j - 1) == s.charAt(i)时 ，
		dp[i + 1][j]相当于＊只代表一个字母
 		dp[i][j + 1]相当于＊代表多个字母，所以把s中的这个字母给删掉了，而p中的这俩字符是保留的
 		dp[i + 1][j - 1]相当于＊及其前一个字母代表空
              

public boolean isMatch(String s, String p) {

    if (s == null || p == null) {
        return false;
    }
    
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    
    
    for (int i = 0; i < p.length(); i++) {
//     	初始化第一行时，此时在dp里相当于s为空
//     	遇到一个＊，就可以忽略它以及它的前一位，相当于[i + 1]＝[i - 1]
        if ( p.charAt(i) == '*' && dp[0][i - 1])  {
            dp[0][i + 1] = true;
        }
    }
    
//     当遇到 .，＊，相等，这三种情况时，是需要考虑约分的
    for (int i = 0 ; i < s.length(); i++) {
        for (int j = 0; j < p.length(); j++) {
//         	遇到点，可以代表任意字母，所以就相当于s和p中都删掉一个字符
            if (p.charAt(j) == '.') {
                dp[i + 1][j + 1] = dp[i][j];
            }
            
//             这两个相等，相当于可以同时删除掉
            if (p.charAt(j) == s.charAt(i)) {
                dp[i + 1][j + 1] = dp[i][j];
            }
            
//             遇到＊时
            if (p.charAt(j) == '*') {
//             	s='a' p='c*'时，false
// 				在下面这个if的条件时，相当于＊没有起到任何作用，所以可以忽略掉＊及其前面的一位
// 				所以[j + 1]＝[j - 1]
                if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                    dp[i + 1][j + 1] = dp[i + 1][j - 1];
                
//                 当p.charAt(j - 1) == s.charAt(i)时 
// 				dp[i + 1][j]相当于＊只代表一个字母
// 				dp[i][j + 1]相当于＊代表多个字母，所以把s中的这个字母给删掉了，而p中的这俩字符是保留的
// 				dp[i + 1][j - 1]相当于＊及其前一个字母代表空
                } else {
                    dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                }
            }
        }
    }
    return dp[s.length()][p.length()];
}

先把words放进char矩阵里，和图例中一模一样的排列
然后i 移动比较的起点，j＝i开始
j移动比较的位置
每一次都比较对称的两个位置是否相等，不等就false

public class Solution {
    public boolean validWordSquare(List<String> words) {
    
        int size = words.size();
        char[][] letters = new char[size][size];
        int r = 0;
        
//         把words放进char矩阵里，一模一样的排列
        // copy words into a 2D array
        for (String s : words) {
        
            if (s.length() > size) 
            	return false; // bountry check 
            
            for (int i = 0; i < s.length(); ++i) {
                letters[r][i] = s.charAt(i);
            }
            
            r++;
        }
        
//         j = i 就决定了每一轮比较的起点是对角线上的点
// 		letters[i][j] 和 letters[j][i] 就是矩阵中对称的的位置
        // check 2d, fast
        for (int i = 0; i < size; ++i) {
            for (int j = i; j < size; ++j) {
                if (letters[i][j] != letters[j][i]) 
                	return false;
            }
        }
        
        return true;
    }
}
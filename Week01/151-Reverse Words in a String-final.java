/*
［问题］
有思路，但是不会用 java 的 stirng，arraylist 等数据结构，就找了个思路相似的代码模仿了一下
代码中 // ??? 都是不会的问题


*/

/*
［我原来思路］
1. 从后向前扫，首次遇到字母就看作单词的终点，继续扫描，直到遇到一个空格，这中间的部分当作一个整体保存起来
2. 把这个整体 append 到一个结构里，并加上一个空格
3. 继续向前扫描，同样的操作，如果过程中连续遇到空格，就继续扫描
4. 一直到 input string 的头被扫完
5. 上述4步结束后，结果的末尾会有一个空格，所以需要把末尾的空格去掉

*/


public class Solution {
	public String reverseWords (String s){
	
		// string 是否为空 的判断 两种区别没听懂
	
		// To store words
		ArrayList<String> list = new ArrayList<String>();	// ??? why ArrayList? can store different length?
		
		int i = 0;
		int n = s.length();  
		
		while ( i < n ){
			if ( !(s.charAt(i) == ' ') ){ 
				int j = i;
				String tmp = "";
				
				// To store single word
				while ( j < n && !(s.charAt(j) == ' ') ){
					tmp += s.charAt(j);  
					j++;
				}
				
				// Add single word to ArrayList
				list.add(tmp);  
				i = j;
			}else 
				i++;
		}
		
		String result = "";  
		
		// Get word from end to start, store in string
		for ( int j = list.size() -1; j >= 0; j-- ){
			result = result + list.get(j) + " ";
		}
		
		// 
		return result.equals("") ? result : result.substring(0, result.length()-1);  // ??? result.equals("") 
		
	}
}
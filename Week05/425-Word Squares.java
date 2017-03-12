

By considering the word squares as a symmetric matrix, 
my idea is to go through the top right triangular matrix in left-to-right and then down order.
For example, with the case of ["area","lead","wall","lady","ball"] where length = 4,
we start with 4 empty string
""
""
""
""
Next, [0,0] , "a","b", "l", "w" can be placed, we start with "a"
"a"
""
""
""
[0,1] go right, "r" can be placed after "a", but no words start with "r" at [1,0], so this DFS ends.
"ar"
""
""
""
Now, start with "b" at [0,0]
"b"
""
""
""
We can have "ba" at [0,1] and there is a word start with "a"
"ba"
"a"
""
""
Next
"bal"
"a"
"l"
""
Next
"ball"
"a"
"l"
"l"
When finish the first row, go down to next row and start at [1,1]
"ball"
"ar"
"l"
"l"
..... so on and so forth until reaching [4,4]

public class Solution {
    class Node{
        Node[] nodes;
        String word;
        
        Node(){
            this.nodes = new Node[26];
            this.word = null;
        }
    }
    
//     从root出发，一个path代表一个word，它叶子放这个word
    void add(Node root, String word){
        Node node = root;
        
        for (char c : word.toCharArray() ) {
            int idx = c - 'a';
            if (node.nodes[idx] == null) ｛
            	node.nodes[idx] = new Node();
            ｝
            node = node.nodes[idx];
        }
        
        node.word = word;
    }
    
    void helper(int row, int col, int len, Node[] rows, List<List<String>> ret) {
    
        if ( (col == row) && (row == len) ) { // last char
            
            List<String> res = new ArrayList<String>();
            
//             最后rows的每个元素都会走到每个单词的最后一个node上
//             遍历4个元素，直接提取每个node上的word，add到最终res中
            for (int i = 0; i < len; i++) {
                res.add( new String(rows[i].word) );
            }
            
            ret.add( res );
           
        // from left to right and then go down to the next row 
        } else { 
            
            // left to right first
            if ( col < len  ) { 
//             	用来记忆之前的状态，方便退回时还原
                Node pre_row = rows[row];
                Node pre_col = rows[col];
                
//                 第一层时，这个i相当于在看谁可以当第一个单词
                for (int i = 0; i < 26; i++) { // find all the possible next char
                    
                    if ( (rows[row].nodes[i] != null) && (rows[col].nodes[i] != null) ) {
//                     	如果遇到可以匹配的，就移动node
                        rows[row] = rows[row].nodes[i];
                        
                        if (col != row) {
                        	rows[col] = rows[col].nodes[i];
                        }
                        
//                         row不变，相当于是固定扫当前行的每一个位置
//                         于此同时，col每一次都＋1，相当于在与row轴对称地走每一个位置

//                         row不变，col＋1，是从left到right
                        helper(row, col + 1, len, rows, ret);
                        
//                         退出了dfs，变回原来的node
                        rows[row] = pre_row;                        
                        
                        if (col != row) {
                        	rows[col] = pre_col;
                        }
                    }
                }
               
            // reach the end of column, go to the next row 
//             row=0的走完了所有的col，此时row＝＝col都放在row＋1上
//             然后重复上面一块的逻辑，即row走完当前行，同时col对称地走，
//             每一次都是直角的两边同时走
            } else { 
                helper(row + 1, row + 1, len, rows, ret);
            }
            
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ret = new ArrayList();
        
        if (words==null || words.length==0) {
        	return ret;
        }
        
        Node root = new Node();
        int len = words[0].length();
        
//         建立字典树
        for (String word: words) {
        	add(root, word);
        }
        
        Node[] rows = new Node[len];
        
//         rows的四个元素初始化都是root
//         每个元素代表最终结果的一行
        for (int i = 0; i < len; i++) {
        	rows[i] = root;
        }
        
//         用dfs去填充这个rows
        helper(0, 0, len, rows, ret);
        
        return ret;
    }
}
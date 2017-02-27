

add：
word的第一个首字母add进来
word去掉第一个字母，传递下去

search：
遇到'.'后，就每个i分叉走一遍，去找word.substring(1)，找到了就是true，否则false
以前是判断一下当前应该在的位置，就走一条叉
当前位置没有这个字母，就是false，是的话，就沿着当前点，找后面部分

public class WordDictionary {
	public class Trie{
		public char val;
		public Trie() children = new Trie[26];
		public boolean isLeaf = false;

		public Trie(){

		}
		
		public Trie( char val ){
			this.val = val;
		}
	}
	
	public Trie root;
	
	public WordDictionary(){
		root = new Trie();
	}
	
	public void addWord( String word ){
		if ( word == null || word.length() == 0 ){
			return;
		}
		addHelper(word, root);
		return;
	}
	
    public void addHelper(String word, Trie root){
        if(word == null || word.length() == 0){
            root.isLeaf = true;
            return;
        }
        
//         word的第一个首字母add进来
        if(root.children[word.charAt(0) - 'a'] == null){
            root.children[word.charAt(0) - 'a'] = new Trie(word.charAt(0));
        }
        
//         word去掉第一个字母，传递下去
        addHelper(word.substring(1), root.children[word.charAt(0) - 'a']);
        return;
    }

    public boolean search(String word) {
        if(word == null || word.length() == 0){
            return true;
        }
        return searchHelper(word, root);
    }

    public boolean searchHelper(String word, Trie root){
        if(root == null){
                return false;
        }
        
        if(word == null || word.length() == 0){
            return root.isLeaf;
        }
        
        if(word.charAt(0) == '.'){
//         	遇到'.'后，就每个i分叉走一遍，去找word.substring(1)，找到了就是true，否则false
// 			以前是判断一下当前应该在的位置，就走一条叉
            for(int i = 0; i < 26; i++){
                if(searchHelper(word.substring(1), root.children[i])){
                    return true;
                }
            }
            return false;
        }else{
//         	当前位置没有这个字母，就是false，是的话，就沿着当前点，找后面部分
            if(root.children[word.charAt(0) - 'a'] == null){
                return false;
            }
            return searchHelper(word.substring(1), root.children[word.charAt(0) - 'a']);
        }

    }
}



//trie
class TrieNode{
	Char c;
	TrieNode[] children= new TrieNode[26];
	boolean isWord;
	
	public TrieNode(){							//
	
	}
	
	public TrieNode( char c ){
		this.c = c;
	}
}


public class Trie{
	public TrieNode root;					//
	
	public trie(){							//
		root = new TrieNode();
	}

//insert
	public void insert( String word ){
		if ( word == null || word.length() == 0 ){
			return root;
		}
	
		int len = word.length();
		TrieNode cur = this.root;							//
	
		for ( int i = 0; i < len; i++ ){
			if ( cur.children[word.charAt(i) -  'a'] == null ){
				TrieNode node = new TrieNode(word.charAt(i));
				cur.children[word.charAt(i) -  'a'] = node;
				cur = node;
			}else{
				cur = cur.children[word.charAt(i) - 'a'];			//
			}
		}
	
		cur.isWord = true;
		return;												//
	}

//search
	public boolean search( String word ){
		if ( word == null || word.length() == 0 ){
			return true;
		}
	
		int len = word.length();
		TrieNode cur = this.root;						//
	
		for ( int i = 0; i < len; i++ ){
			if ( cur.children[word.charAt(i) - 'a'] == null ){
				return false;
			}else{
				cur = cur.children[word.charAt(i) - 'a'];
			}
		}
	
		return cur.isWord;
	
	}

//start with
	public boolean start( String word ){
		if ( word == null || word.length == 0 ){
			return true;
		}
	
		int len = word.length();
		TrieNode cur = this.root;						//
	
		for ( int i = 0; i < len; i++ ){
			if ( cur.children[word.charAt(i) - 'a'] == null ){
				return false;
			}else{
				cur = cur.children[word.charAt(i) - 'a'];
			}
		}
	
		return true;
	}



}






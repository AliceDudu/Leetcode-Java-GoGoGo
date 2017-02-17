public class Solution{
	public int ladderLength(String beginWord, String endWord, List<String> wordList){
		if ( beginWord == null || endWord == null || wordList == null ){
			return 0;
		}
		if ( wordList.size() == 0 ){	//length
			return 0;
		}
		
		Set<String> dict = new HashSet<>(wordList);
		
		if ( !dict.contains(endWord) ){
			return 0;
		}
		
		return biBFS(beginWord, endWord, dict);
	}
	
	public int biBFS( String beginWord, String endWord, Set<String> dict ){
	
		Set<String> beginSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();
		
		Set<String> visited = new HashSet<>();
		int steps = 0;
		
		beginSet.add(beginWord);
		endSet.add(endWord);
		
		visited.add(beginWord);
		visited.add(endWord);	//--
		
		
		while( !beginSet.isEmpty() && !endSet.isEmpty() ){		//&&
			
			steps++;
			
			if ( beginSet.size() > endSet.size() ){
				Set<String> tmp = beginSet;
				beginSet = endSet;
				endSet = tmp;
			}
			
			Set<String> nextLevel = new HashSet<>();		//~=queue
			
			for ( String curStr : beginSet ){
				for ( int i = 0; i < curStr.length(); i++ ){
					for ( char j = 'a'; j <= 'z'; j++ ){
						String toCheck = replace(curStr, i, j);
						
						if ( endSet.contains(toCheck) ){		//why???
							return ++steps;
						}
						
						if ( dict.contains(toCheck) && visited.add(toCheck) ){
							nextLevel.add(toCheck);
						}
					}
				}
			}
			
			beginSet = nextLevel;
			
		}
		return 0;
	}
	
	public String replace( String word, int pos, char newCh ){
		char[] chs = word.toCharArray();
		chs[pos] = newCh;
		return new String(chs);
	}
}





begin word 从第一个字母开始变成 a～z 一直到最后一个字母都要变，
每次变化后看是否＝＝end Word了，等于就返回steps＋1，不等于就继续
每次变化后同dict里比较，若有相同的，则放入queue中
下一步从queue挑下一个点，同样变换的操作

public class Solution{
	public int ladderLength(String beginWord, String endWord, List<String> wordList){
		if ( beginWord == null || endWord == null || wordList == null ){
			return 0;
		}
		if ( wordList.size() == 0 ){
			return 0;
		}
		
		//--
		Set<String> dict = new HashSet<>();
		for ( String word : wordList ){
			dict.add(word);
		}
		
		if ( !dict.contains(endWord) ){
		    return 0;
		}
		
		return bfs(beginWord, endWord, dict);
	}
	
// 	public int bfs( String beginWord, String endWord, List<String> wordList ){
	public int bfs( String beginWord, String endWord, Set<String> dict ){
		Queue<String> queue = new LinkedList<String>();	//--
		HashSet<String> visited = new HashSet<String>();	//--
		int steps = 0;
		
		queue.offer(beginWord);	//--
		visited.add(beginWord);
		
		while( !queue.isEmpty() ){
			int size = queue.size();
			steps++;
			
			for ( int i = 0; i < size; i++ ){
				String cur = queue.poll();
				
				for ( int j = 0; j < cur.length(); j++ ){
					for ( char k = 'a'; k <= 'z'; k++ ){
						if ( k == cur.charAt(j) ){	//--
							continue;
						}
						
						String toStr = replace(cur, j, k);
					
						if ( toStr.equals(endWord) ){
							return ++steps;
						}
						
						if ( dict.contains(toStr) && visited.add(toStr)  ){	  
							queue.offer(toStr);
						}
                // 		if ( dict.contains(toStr) ){
				// 			if ( visited.contains(toStr) ){
				// 				continue;
				// 			}
							
				// 			if ( toStr.equals(endWord) ){
				// 				return ++steps;
				// 			}
							
				// 			queue.offer(toStr);
				// 			visited.add(toStr);
							
				// 		}
					}
				}
			}
		}
		return 0;
	}
	

	
	public String replace( String str, int pos, char newCh ){
		char[] chs = str.toCharArray();
		chs[pos] = newCh;
		return new String(chs);
	}
	


}

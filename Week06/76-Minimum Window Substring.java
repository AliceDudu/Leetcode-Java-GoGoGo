public class Solution{
	public String minWindow( String S, String T ){
		HashMap<Character, Integer> dict = new HashMap<>();
		
		for ( int i = 0; i < T.length(); i++ ){	//y
			char c = T.charAt(i);
			if ( !dict.containsKey(c) ){
				dict.put(c, 1);
			}else{
				dict.put(c, dict.get(c) + 1);
			}
		}
		
		HashMap<Character, Integer> found = new HashMap<>();	//n
		
		int foundCounter = 0;	//n qty of found characters
		int start = 0; 
		int end = 0;
		int min = Integer.MAX_VALUE;	//n
		
		String minWindow = "";
		
		while ( end < S.length() ){
			char c = S.charAt(end);
			
			if ( dict.containsKey(c) ){
				if ( found.containsKey(c) ){
					if ( found.get(c) < dict.get(c) ){	//n duplicates c in T
						foundCounter++;
					}
					found.put(c, found.get(c) + 1);		//n qty added
				}else{
					found.put(c, 1);
					foundCounter++;
				}
			}
			
			if ( foundCounter == T.length() ){	//n found all chs
				char sc = S.charAt(start);
				
				while ( !found.containsKey(sc) || found.get(sc) > dict.get(sc) ){	//n
					if ( found.containsKey(sc) && found.get(sc) > dict.get(sc) ){
						found.put(sc, found.get(sc) - 1);
					}
					start++;
					sc = S.charAt(start);
				}
				
				if ( end - start + 1 < min ){	//y update min
					minWindow = S.substring(start, end + 1);
					min = end - start + 1;
				}
			}
			end++;
		}
		return minWindow;
		
	}
}
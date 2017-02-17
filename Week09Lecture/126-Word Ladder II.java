public class Solution{
	public List<List<String>> findLadders( String start, String end, List<String> wordList ){
		List<List<String>> res = new ArrayList<List<String>>();
		Set<String> dict = new HashSet<>(wordList);
		
		if ( !dict.contains(end) ){
			return res;
		}
		
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		
		set1.add(start);
		set2.add(end);
		
		// we use a map to help construct the final result
		Map<String, List<String>> map = new HashMap<>();	//--val? key?
		
		// build the map
		finder(dict, set1, set2, map, false);
		
		List<String> sol = new ArrayList<>(Arrays.asList(start));
		
		// recursively build the final result
		generateList(start, end, map, sol, res);
		
		return res;
	}
	
	//flip??
	boolean finder( Set<String> dict, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean flip ){
		if ( set1.isEmpty() ){
			return false;
		}
		
		// small size set to be beginSet
		if ( set1.size() > set2.size() ){
			return finder(dict, set2, set1, map, !flip);	//!flip
		}
		
		// remove words on current both ends from the dict
		dict.removeAll(set1);		//--
		dict.removeAll(set2);
		
		// as we only need the shortest paths
	    // we use a boolean value help early termination
		boolean done = false;
		
		// set for the next level
		Set<String> setNext = new HashSet<>();
		
		// for each string in end 1
		for ( String str : set1 ){
			for ( int i = 0; i < str.length(); i++ ){
				char[] chars = str.toCharArray();
				
				// change one character for every position
				for ( char ch = 'a'; ch <= 'z'; ch++ ){
					chars[i] = ch;
					
					String word = new String(chars);
					
					// make sure we construct the tree in the correct direction
					String key = flip ? word : str;		//--
					String val = flip ? str : word;
					
					List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();
					
					if ( set2.contains(word) ){
						done = true;
						list.add(val);
						map.put(key, list);
					}
					
					if ( !done && dict.contains(word) ){
						setNext.add(word);
						list.add(val);
						map.put(key, list);
					}
					
				}
			}
		}
		
		return done || finder(dict, set2, setNext, map, !flip);
	}
	
	//--
	public void generateList(String start, String end, Map<String, List<String>> map, List<String> sol, List<List<String>> res){
		if ( start.equals(end) ){
			res.add(new ArrayList<String>(sol));
			return;
		}
		
		if ( !map.containsKey(start) ){
			return;
		}
		
		for ( String word : map.get(start) ){
			sol.add(word);
			generateList(word, end, map, sol, res);
			sol.remove(sol.size() - 1);
		}
	}
	
}








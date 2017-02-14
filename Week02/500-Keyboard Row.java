

public class Solution{
	public String[] findWords( String[] words ){
		String[] stairs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
		
		Map<Character, Integer> map = new HashMap<>();
		
		//stairs ~ index
		for ( int i = 0; i < stairs.length; i++ ){
			for ( char c : stairs[i].toCharArray() ){
				map.put(c, i);
			}
		}
		
		List<String> res = new ArrayList<>();
		
		for ( String w : words ){
			if ( w.equals("") ){
				continue;
			}
			
			int index = map.get( w.toUpperCase().charAt(0) );	//每个单词第一个字母
			
			for ( char c : w.toUpperCase().toCharArray() ){		//每个单词变成c的array
				if ( map.get(c) != index ){
					index = -1;		//not boolean
					break;
				}
			}
			
			if ( index != -1 ){
				res.add(w);
			}
		}
		
		return res.toArray(new String[0]);		
	}
}

// iterate through each word and see if it can be formed by using other words.
// first sort the input by length of each word, 
// and only try to form one word by using words in front of it.

public class Solution{
	public List<String> findAllConcatenatedWordsInADict( String[] words ){
		List<String> res = new ArrayList<>();
		Set<String> preWords = new HashSet<>();
		Arrays.sort(words, new Comparator<String>(){
			public int compare ( String s1, String s2 ){
				return s1.length() - s2.length();			//
			}
		});
		
		for ( int i = 0; i < words.length; i++ ){
			if ( canForm(words[i], preWords) ){
				res.add(words[i]);
			}
			
			preWords.add(words[i]);
		}
		
		return res;
	}
	
	public boolean canForm( String word, Set<String> dict ){
		if ( dict.isEmpty() ){
			return false;
		}
		
		boolean[] dp = new boolean[word.length() + 1];
		
		dp[0] = true;
		
		for ( int i = 1; i <= word.length(); i++ ){
			for ( int j = 0; j < i; j++ ){
				if ( !dp[j] ){
					continue;
				}
				if ( dict.contains(word.substring(j, i)) ){
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[word.length()];
	}
}

定义一个map
缩写形式作为key，原单词作为value
遍历单词表 str : dictionary
map中这个key的原单词如果不等于当前的单词str时，说明有多个单词有same缩写，就把value设成空
若没有，就把缩写和单词放入map
	判断唯一时true的情况：
	map里没有出现过这个word的缩写形式
	或者出现了这个形式，但是单词和给定的是一模一样的

public class ValidWordAbbr {

    HashMap<String, String> map;
    
    public ValidWordAbbr(String[] dictionary) {
    
        map = new HashMap<String, String>();
        
        for(String str : dictionary){
            String key = getKey(str);
            // If there is more than one string belong to the same key
            // then the key will be invalid, we set the value to ""
            if( map.containsKey(key) ){
//             	map中这个key的原单词如果不等于当前的单词str时，说明有多个单词有same缩写，就把value设成空
                if( !map.get(key).equals(str) ){
                    map.put(key, "");
                }
            }else{
//             	缩写形式作为key，原单词作为value
                map.put(key, str);
            }
        }
    }

// 	判断是否唯一：
// 	map里没有出现过这个word的缩写形式
// 	或者出现了这个形式，但是单词和给定的是一模一样的
    public boolean isUnique(String word) {
        return !map.containsKey(getKey(word)) || map.get(getKey(word)).equals(word);
    }
    
//     给定str后，返回它的缩写形式，即保留前后两个字母，中间是省略字母的个数
    String getKey(String str){
        if(str.length() <= 2) 
        	return str;
        return str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() - 1);
    }
    
}
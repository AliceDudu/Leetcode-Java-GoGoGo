每个单词，自己内部拍一下序
把这种有序的组成加入到map中，key就是有序的组成，value就是原单词

打乱原来的顺序成为有序的组成后，就可以直接用来判断是否属于同一类了

比较重要的两步：排序，和看整体的组成是否一致

public List<List<String>> groupAnagrams(String[] strs) {

	List<List<String>> res = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMap<>();
    
    Arrays.sort(strs);		
    
    for (int i = 0; i < strs.length; i++) {
    	
    	String temp = strs[i];
    	char[] ch = temp.toCharArray();
    	Arrays.sort(ch);		//1.排序
    	
    	if ( map.containsKey(String.valueOf(ch)) ) {				//2.String.valueOf(ch)
    		map.get(String.valueOf(ch)).add(strs[i]);
    		
    	} else {
    		List<String> each = new ArrayList<>();
    		each.add(strs[i]);				//原字母顺序
    		
    		map.put(String.valueOf(ch), each);
    	}
    }
    
    for (List<String> item: map.values()) {
    	res.add(item);
    }
    
    return res;
}


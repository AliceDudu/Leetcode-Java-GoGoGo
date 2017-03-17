


把words放到map作为key，value就是它出现过的角标，因为会有重复，所以有多个
拿到两个单词的角标list
分别取出一个，计算一下距离
因为放入index时是从前向后遍历的，所以每个list里面也是从小到大的排序
下面的if else是在根据大小顺序看移动哪个index，来缩短二者间距离

public class WordDistance {
    
    HashMap<String, List<Integer>> map = new HashMap<>();  

// 	把words放到map作为key，value就是它出现过的角标，因为会有重复，所以有多个
    public WordDistance(String[] words) {
    
        for (int i = 0; i < words.length; i++) {
        
            if ( !map.containsKey(words[i]) ) {
                List<Integer> list = new LinkedList<>();
                map.put(words[i], list); 
            }
            
            map.get(words[i]).add(i); 
        }   
         
    }

    public int shortest(String word1, String word2) {
    
//     	拿到两个单词的角标list
        List<Integer> list1 = map.get(word1); 
        List<Integer> list2 = map.get(word2); 
        
        int ind1 = 0, ind2 = 0, shortest = Integer.MAX_VALUE; 
        
        while ( ind1 < list1.size() && ind2 < list2.size() ) {
        
//         	分别取出一个，计算一下距离
            shortest = Math.min(shortest, Math.abs( list1.get(ind1) - list2.get(ind2)) ); 
            
//             因为放入index时是从前向后遍历的，所以每个list里面也是从小到大的排序
//             下面的if else是在根据大小顺序看移动哪个index，来缩短二者间距离
            if ( list1.get(ind1) > list2.get(ind2) ) 
            	ind2++; 
            else 
            	ind1++; 
        }
        
        return shortest; 
    }
    
}
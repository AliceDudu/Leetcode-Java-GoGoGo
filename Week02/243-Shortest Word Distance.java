https://discuss.leetcode.com/topic/71015/clean-java-solution

https://discuss.leetcode.com/topic/75043/my-2ms-java-solution

遍历一遍，找到两个给定单词的角标位置
每次找到一个时，就计算一下两个单词的角标距离，记忆最小值

public class Solution {
    //assume: word1 does not equal to word2, and word1 and word2 are both in the list.
    //word in words may the same word
    public int shortestDistance(String[] words, String word1, String word2) {
    
        //to make the distance in a reasonable range: not overflow
        int index_1 = words.length;
        int index_2 = words.length;
        
        //set the min distance between two words
        int min = Integer.MAX_VALUE;
        
//         遍历一遍，找到两个给定单词的角标位置
        for(int i = 0; i < words.length; i++) {
        
//         	每次找到一个时，就计算一下两个单词的角标距离，记忆最小值
            if(words[i].equals(word1)){
                index_1 = i;
                min = Math.min(min, Math.abs(index_2 - index_1));
            }
            else if(words[i].equals(word2)){
                index_2 = i;
                min = Math.min(min, Math.abs(index_2 - index_1));
            }
            
        }
        
        return min;
    }
}
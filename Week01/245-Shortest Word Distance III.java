

public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(words == null || words.length < 2) return 0;

        int p1 = -1;
        int p2 = -1;
        int min = Integer.MAX_VALUE;

        if(word1.equals(word2)){
            for(int i = 0;i < words.length; i ++){
                //we always keep p1 < p2
                if(words[i].equals(word1)){
                    if(p1 == -1){
                        p1 = i;
                    }else if(p2 == -1){
                        p2 = i;
                    }else{
                        p1 = p2;
                        p2 = i;
                    }
                    
                    if(p1 != -1 && p2 != -1){
                        min = Math.min(min, p2 - p1);
                    }
                }
            }
        }else{
            for(int i = 0;i < words.length; i ++){
                if(words[i].equals(word1)) p1 = i;
                if(words[i].equals(word2)) p2 = i;

                if(p1 != -1 && p2 != -1){
                    min = Math.min(min, Math.abs(p1 - p2));
                }
            }
        }
        return min;
    }
}

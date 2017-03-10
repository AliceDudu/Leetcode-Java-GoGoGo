

根据回车符\n把每段分割开了，
然后对于每一行，我们找最后一个空格符\t的位置，
然后可以得到文件或文件夹的名字，然后我们判断其是文件还是文件夹，
如果是文件就更新res，
如果是文件夹就更新哈希表的映射

public class Solution {
    public int lengthLongestPath(String input) {
        int res = 0;
        
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 0);

//         	根据回车符\n把每段分割开了，           
        for (String s : input.split("\n")) {    
// 			然后对于每一行，我们找最后一个空格符\t的位置，
            int level = s.lastIndexOf("\t") + 1;
//             从level开始向后
            int len = s.substring(level).length();
            
//             如果是文件就更新res，
            if (s.contains(".")) {
                res = Math.max(res, m.get(level) + len);
//             如果是文件夹就更新哈希表的映射
            } else {
                m.put(level + 1, m.get(level) + len + 1);  		// 加1是因为有个斜杠
            }
        }
        
        return res;
    }
}




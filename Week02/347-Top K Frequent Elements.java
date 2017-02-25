

先用map统计每个数字出现的总数frequency
然后按照frequency作为index，去把数字填充到一个bucket里
读取ans的时候，因为是要最长的k个，
所以i从bucket的后面向前扫，扫到每一个有数字的点时，
把这一串都加到ans里，k要减去这一串的个数
用此方法i继续向前走



public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
    
        int n = nums.length;
        HashMap<Integer, Integer> h = new HashMap();
        
//         用map统计每个数字出现的总数
        for (int i : nums)
            if ( h.containsKey(i) )
                h.put(i, h.get(i) + 1);
            else
                h.put(i, 1);
        
        List<Integer>[] fc = new ArrayList[n + 1];
        
        for (int i : h.keySet()) {
            int f = h.get(i);       //System.out.println(f + " times of " + i);
            
            if (fc[f] == null) 
            	fc[f] = new ArrayList();
            	
            fc[f].add(i);
        }
        
        List<Integer> ans = new ArrayList();
        
        for (int i = n, j = 0; k > 0; k--) {
            for (; fc[i] == null || j == fc[i].size(); j = 0, i--);		//这句写的不易读
            	ans.add(fc[i].get(j++));
        }
        
        return ans;
    }
}
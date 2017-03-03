

用postorder遍历
每次，走完这个以当前root为根的子树了，就计算一下这一子树的和sum
用map来存sum和它的出现次数
把这个sum出现的次数计数＋1，并且更新map里的val 
maxcount用来追踪目前为止出现次数最多的count

post走完一遍，可以得到map里的各个sum和出现次数，还有maxcount最大的次数
把所有次数等于最大次数的sum都取出来
用int返回最后的结果


public class Solution {

    Map<Integer, Integer> sumToCount;
    int maxCount;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        maxCount = 0;
        sumToCount = new HashMap<Integer, Integer>();
        
//         这样post走完一遍，可以得到map里的各个sum和出现次数，还有maxcount最大的次数
        postOrder(root);
        
        List<Integer> res = new ArrayList<>();
        
//         把所有次数等于最大次数的sum都取出来
        for ( int key : sumToCount.keySet() ) {
            if ( sumToCount.get(key) == maxCount ) {
                res.add(key);
            }
        }
        
//         用int返回最后的结果
        int[] result = new int[res.size()];
        for ( int i = 0; i < res.size(); i++ ) {
            result[i] = res.get(i);
        }
        
        return result;
    }
    
    private int postOrder(TreeNode root) {
//     	走到底端的null了
        if (root == null) {
        	return 0;
        }
        
//         postorder－左
        int left = postOrder(root.left);
//         postorder－右
        int right = postOrder(root.right);
//         postorder－根
//         走完这个以当前root为根的子树了，就计算一下这一子树的和sum
        int sum = left + right + root.val;

// 			把这个sum出现的次数计数＋1，并且更新map里的val       
        int count = sumToCount.getOrDefault(sum, 0) + 1;
        sumToCount.put(sum, count);
        
//         maxcount用来追踪目前为止出现次数最多的count
        maxCount = Math.max(maxCount, count);
        
        return sum;
    }
}


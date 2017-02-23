我发现，自己跑出来一遍eg之后，就明白了很多，包括老师讲的话

因为要求 最长的 sub seq 有多长：
所以，用一个 seq 存最长的 seq
用 seqLen 来记录最长的 seq 有多长，最后返回它

每次走到一个 num i，就用二分查找，在已有的 incresing seq 里，找到当前 num i 应该放在何处，放进去
并用 insertPos 来记录 num i 该放在的位置

如果在 start 上大于 num i 了，则需要把小的 num i 放在这，这样后面才可能放更多的大的值，
如果小于，就把它放在 end 上

用 insertPos 与 seqLen 比较
insertPos == seqLen 说明 num i 比当前 seq 里最大的还大，直接被加到 seq 的尾巴上
加进来一个，则 len 向后移动一位
否则的话，len 不变

酱紫最后返回 seqLen 即可


public class Solution {
    public int lengthOfLIS( int[] nums ){
    	
    	int[] increSeq = new int[nums.length];		//用一个 seq 存最长的 seq
    	int seqLen = 0;			//用来记录最长的 seq 有多长，最后返回它
    
    	for( int i = 0; i < nums.length; i++ ){
    	
    		//二分查找，在已有的 incresing seq 里，当前 num i 应该放在何处
        	int start = 0;
        	int end = seqLen;
        	
        	while( start < end - 1 ){
        	
            	int mid = start + (end - start) / 2;
            	
            	if( increSeq[mid] < nums[i] ){
	                start = mid;
	            }else{
	                end = mid;
	            }
        	}		//最后剩下 start 和 end 两个点，需要进一步判断 num i 该放在哪里
        	
        	int insertPos = 0;	//用来记录 num i 该放在的位置
        	
        	if( increSeq[start] >= nums[i] ){		//如果 start 上大于 num i 了，则需要把小的 num i 放在这，这样后面才可能放更多的大的值
        		increSeq[start] = nums[i];
        		insertPos = start;
        	}else{			//为什么不是start就一定是end呢？没有中间了么？哦，对，这个模版就是在最后一步判断两头的
        		increSeq[end] = nums[i];	//如果小于，就把它放在 end 上
        		insertPos = end;
        	}
        	
        	//用 insertPos 与 seqLen 比较
        	if( insertPos == seqLen ){		//insertPos == seqLen 说明 num i 比当前 seq 里最大的还大，直接被加到 seq 的尾巴上
        		seqLen++;		//加进来一个，则 len 向后移动一位
        	}
    	}
    
    	return seqLen;
	}
}


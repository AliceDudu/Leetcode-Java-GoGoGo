//bit

public class NumArray {
	int[] nums;
	int[] bit;
	int len;

	//build
    public NumArray(int[] nums) {
    	this.nums = nums;				//
    	
    	len = nums.length;
    	bit = new int[len + 1];
    	
        for ( int i = 0; i < len; i++ ){
        	initial(i, nums[i]);
        }
    }
    
    public void initial( int i, int val ){
    	i++;
    	while ( i <= len ){
    		bit[i] += val;
    		i += (i & -i); 
    	}
    }
    
    //update
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        initial(i, diff);
    }
    
    //range sum
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
    
    public int getSum( int i ){
    	int sum = 0;
    	i++;					//
    	while ( i > 0 ){
    		sum += bit[i];
    		i -= (i & -i);
    	}
    	return sum;				//
    }
}

//segment
class SegmentNode{
	int beg, tail;
	SegmentNode left, right;
	int sum;
	
	public SegmentNode( int beg, int tail ){
		this.beg = beg;							//
		this.tail = tail;
		this.sum = 0;
		this.left = null;
		this.right = null;
	}
}

public class NumArray {
	//build
	SegmentNode root = null;					//
	
    public NumArray(int[] nums) {						//
        root = buildHelper(nums, 0, nums.length - 1);
    }
    
    public SegmentNode buildHelper( int[] nums, int start, int end ){		//
    	//base
    	if ( start > end ){
    		return null;
    	}else{		//
    	//current
    		SegmentNode node = new SegmentNode(start, end);			//
    	
    		if ( start == end ){
    			node.sum = nums[start];					//not root
    		}else{
    			int mid = start + (end - start) / 2;				//
    		
    			node.left = buildHelper(nums, start, mid);
    			node.right = buildHelper(nums, mid + 1, end);
    		
    			node.sum = node.left.sum + node.right.sum;
    		}
    		return node;											//
    	}
    }
    
    //update
    public void update(int i, int val) {
        updateHelper(root, i, val);
    }
    
    public void updateHelper( SegmentNode root, int pos, int val ){
    	//base
    	if ( root.beg == root.tail ){
    		root.sum = val;
    	}else{			//
    	
    	//current
    		int mid = root.beg + (root.tail - root.beg) / 2;
    	
    		if ( pos <= mid ){
    			updateHelper(root.left, pos, val);
    		}else{
    			updateHelper(root.right, pos, val);
    		}
    	
    		root.sum = root.left.sum + root.right.sum;
    	}
    	
    }
    
    //range sum
    public int sumRange(int i, int j) {
        return sumRangeHelper(root, i, j);
    }
    
    public int sumRangeHelper( SegmentNode root, int start, int end ){
    	//base
    	if ( root.beg == start && root.tail == end ){
    		return root.sum;
    	}else{			//
    	
    	//current
    		int mid = root.beg + (root.tail - root.beg) / 2;
    	
    		if ( end <= mid ){
    			return sumRangeHelper(root.left, start, end);
    		}else if ( start >= mid + 1 ){
    			return sumRangeHelper(root.right, start, end);
    		}else{
    			return sumRangeHelper(root.left, start, mid) + sumRangeHelper(root.right, mid + 1, end);
    		}
    	}
    }
}




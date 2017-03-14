

初始时为第一层
然后一层一层地剥皮
每剥一次就depth＋1
遇到一个数字时，就乘以当前的depth，加到ret里

public int depthSum(List<NestedInteger> nestedList) {
    return helper(nestedList, 1);
}

private int helper(List<NestedInteger> list, int depth)
{
    int ret = 0;
    
    for (NestedInteger e: list)
    {
    	if (e.isInteger()){
//     		遇到一个数字时，就乘以当前的depth，加到ret里
    		ret += e.getInteger() * depth;
    	}else{
//     		遇到一层list的话，depth就要＋1
    		ret += helper(e.getList(), depth + 1);
    	}
    }
    
    return ret;
}
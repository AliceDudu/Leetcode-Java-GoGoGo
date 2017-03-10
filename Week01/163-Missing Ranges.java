
private String outputRange(int n, int m) {
	return (n == m) ? String.valueOf(n) : n + "->" + m;
}

public List<String> findMissingRanges(int[] nums, int lower, int upper) {
// 	用来连接每个区间段
	List<String> ranges = new ArrayList<String>();

	if (nums.length == 0) {  //Empty array misses the range lower->upper.
		ranges.add(outputRange(lower, upper));
		return ranges;
	}

	int prev;

// 	把开头的一部分先求出来
// 	if (nums[0] - lower > 0) {    //Handles lower boundary. Notice "inclusive".
	if (nums[0] > lower) { 
		ranges.add(outputRange(lower, nums[0] - 1));
		prev = nums[0];
	
	} else {
		prev = lower;
	}

	for (int i = 1; i < nums.length; i++) {
// 	for (int cur : nums) {
// 		cur和pre＝1说明是连续的，否则的话就是有间断，需要构造中间的区间
		int cur = nums[i];
// 		if (cur - prev > 1) {
		if (cur != Integer.MIN_VALUE && cur - 1 > prev) {
			ranges.add(outputRange(prev + 1, cur - 1)); //Misses range if distance > 1.
		}
// 		cur向后走，pre也是
		prev = cur;
	}

// 	再把尾巴的一部分求出来
// 	if (upper - prev > 0) {  //Handles the upper boundary.
	if (upper > prev) {
		ranges.add(outputRange(prev + 1, upper));
	}
	
// 	最后返回结果
	return ranges;
}


Input:
[2147483647]
0
2147483647
Output:
["0->2147483646","-2147483648->2147483647"]
Expected:
["0->2147483646"]
酱紫改：
	for (int i = 1; i < nums.length; i++) {
// 	for (int cur : nums) {


Input:
[-2147483648,2147483647]
-2147483648
2147483647
Output:
[]
Expected:
["-2147483647->2147483646"]
酱紫改
// 		if (cur - prev > 1) {
		if (cur - 1 > prev) {
		
Input:
[-2147483648,-2147483648,0,2147483647,2147483647]
-2147483648
2147483647
Output:
["-2147483647->2147483647","-2147483647->-1","1->2147483646"]
Expected:
["-2147483647->-1","1->2147483646"]
酱紫改
// 		if ( cur - 1 > prev) {
		if (cur != Integer.MIN_VALUE && cur - 1 > prev) {

Input:
[2147483647]
-2147483648
2147483647
Output:
[]
Expected:
["-2147483648->2147483646"]
酱紫改
// 	if (nums[0] - lower > 0) {    
	if (nums[0] > lower) { 

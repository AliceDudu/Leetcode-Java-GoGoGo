

![](http://upload-images.jianshu.io/upload_images/1667471-71a19a64d3062269.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- 用一个tmp path来遍历每一条可能的组合
- 只把其中符合 remove＝＝0 的path加到最终的res中
- 先将array排序
- 第一遍，i从0开始遍历，逐个加到path中，相当于在累加，
- 如果和小于target，即remain大于0就继续累加，如果remain小于0就返回到上一层，如果等于0就把路径加到res中
- 因为不允许同样组成的组合重复出现在res中，所以排序后，比较是否相等，有相等元素的直接跳过，这样不会同一个位置被add了好几次同样的数字
- 第二遍，i从‘2’开始

```java
public class Solution {
	public List<List<Integer>> combinationSum2( int[] candidates, int target ){
   		List<List<Integer>> list = new LinkedList<List<Integer>>();
   		Arrays.sort(candidates);
   		backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
   		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start){
	   if( remain < 0 ){
	   	return; /** no solution */
	   }else if( remain == 0 ){
	   	list.add(new ArrayList<>(tempList));
	   }else{
      		for( int i = start; i < cand.length; i++ ){
         		if( i > start && cand[i] == cand[i-1] ){
         			continue; /** skip duplicates */
         		}
         		tempList.add(cand[i]);
         		backtrack(list, tempList, cand, remain - cand[i], i+1);
         		tempList.remove(tempList.size() - 1);
      		}
   		}
	}
}
```

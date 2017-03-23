

public List<Integer> closestKValues(TreeNode root, double target, int k) {
// 	存结果
  List<Integer> res = new ArrayList<>();

  Stack<Integer> s1 = new Stack<>(); // predecessors
  Stack<Integer> s2 = new Stack<>(); // successors

// 	false意思就是不reverse：left－root－right
// 	true意思就是reverse：right－root－left
  inorder(root, target, false, s1);
  inorder(root, target, true, s2);
  
  while (k-- > 0) {
    if (s1.isEmpty())
      res.add(s2.pop());
    else if (s2.isEmpty())
      res.add(s1.pop());
    else if (Math.abs(s1.peek() - target) < Math.abs(s2.peek() - target))
      res.add(s1.pop());
    else
      res.add(s2.pop());
  }
  
  return res;
}


// inorder traversal：left－root－right
void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {

// 	base就是走到叶子下面
  if (root == null) 
  	return;

// 	如果reverse＝true，就是right－root－left，大中小顺序，所以先放right，再root，再left
  inorder(reverse ? root.right : root.left, target, reverse, stack);
  
//   在root这里有操作
  
  // early terminate, no need to traverse the whole tree
//   在reverse是大中小顺序情况下，如果当前root已经比target小了，就不用再向后走，否则只会越来越小
  if ((reverse && root.val <= target) || (!reverse && root.val > target)) 
  	return;
  	
  // track the value of current node  
//   在root这里，把root放入stack
  stack.push(root.val);
  
//   然后再left
  inorder(reverse ? root.left : root.right, target, reverse, stack);
}
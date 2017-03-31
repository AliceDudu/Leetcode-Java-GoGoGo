

private  TreeNode leftMost;
    private  TreeNode rightMost;

    public  List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);//since the root is special,so we add it first
        leftBoundary(root.left, result);
        if (root.left != null || root.right != null) leavesBoundary(root, result);
        rightBoundary(root.right, result);
        return result;
    }

    private  void leftBoundary(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        leftMost = root;//we visit the left node up to down,and record the leftMost treenode
        leftBoundary(root.left, result);
        if (root.left == null) leftBoundary(root.right, result);

    }

    private  void leavesBoundary(TreeNode root, List<Integer> result) {
        if (root == null) return;
        if (root.left == null && root.right == null){
            if (root != leftMost) result.add(root.val);//since the leftMost node will be duplicate,so we ignore it
            rightMost = root; //as we iterate every leave node,we update the rightMost treenode
        }
        leavesBoundary(root.left, result);
        leavesBoundary(root.right, result);
    }

    private  void rightBoundary(TreeNode root, List<Integer> result) {
        if (root == null) return;
        rightBoundary(root.right, result);
        if (root.right == null) rightBoundary(root.left, result);
        if (root != rightMost) result.add(root.val);//since the rightMost treenode will be duplicate,so we ignore it
    }

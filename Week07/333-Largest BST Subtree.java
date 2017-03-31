


public int largestBSTSubtree(TreeNode root) {
        int[] result = helper(root);
        return result[3];
    }
    public int[] helper(TreeNode node) {
        int[] result = new int[4];
        if (node == null) {
            result[0] = Integer.MAX_VALUE;//min value
            result[1] = Integer.MIN_VALUE;//max value
            result[2] = 1;//is bst or not?
            result[3] = 0;//count
            return result;
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        if (node.val > left[1] && node.val < right[0] && left[2] == 1 && right[2] == 1) {
            result[0] = Math.min(node.val, left[0]);
            result[1] = Math.max(node.val, right[1]);
            result[2] = 1;
            result[3] = left[3] + right[3] + 1;
        } else {
            result[2] = 0;
            result[3] = Math.max(left[3], right[3]);
        }
        return result;
    }
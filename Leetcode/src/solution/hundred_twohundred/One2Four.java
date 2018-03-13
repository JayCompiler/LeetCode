package solution.hundred_twohundred;

/**
 * Binary Tree Maximum Path Sum Given a binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections. The
 * path must contain at least one node and does not need to go through the root.
 * For example: Given the below binary tree,
 * 
 * 1 / \ 2 3 Return 6.
 * 
 * @author zy
 *
 */
public class One2Four {
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(-2);
		//treeNode.left = new TreeNode(1);
		treeNode.right = new TreeNode(3);
		int reS = maxPathSum(treeNode);
		System.out.println(reS);
	}

	public static int maxPathSum(TreeNode root) {
		// if (root == null) {
		// return 0;
		// }
		help(root);
		return max;
	}

	private static int help(TreeNode root) {
		if (root == null) {
			return 0;
		}
		/*
		 * the sum must go though the certain node, recursive right and left,if is
		 * negative to zero
		 */
		int left = Math.max(help(root.left), 0);
		int right = Math.max(help(root.right), 0);
		//max is very important , reserve the global maximum value
		max = Math.max(max, left + right + root.val);
		// amazing idea:if maximum go through the root,
		//it can't go througt both the subnode's left and right
		return Math.max(left, right) + root.val;
	}
}

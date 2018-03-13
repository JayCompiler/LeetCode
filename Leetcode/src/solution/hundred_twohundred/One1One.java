package solution.hundred_twohundred;
/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along
 * the shortest path from the root node down to the nearest leaf node.
 * @author zy
 *
 */

public class One1One {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(-2);
		//treeNode.left = new TreeNode(1);
		//treeNode.right = new TreeNode(3);
		int min=minDepth(treeNode);
		System.out.println(min);
	}

	public static int minDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		if(root.left!=null) {
			if(root.right!=null) {
				return Math.min(minDepth(root.right)+1, minDepth(root.left)+1);
			}else {
				return minDepth(root.left)+1;
			}
		}else {
			return minDepth(root.right)+1;
		}
	}

}

package solution.hundred_twohundred;
/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.For example:
 * Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
 * return its depth = 3.
 * @author zy
 *
 */
public class One0Four {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(-2);
		treeNode.right=new TreeNode(0);
		treeNode.left=new TreeNode(3);
		treeNode.left.left=new TreeNode(3);
		System.out.println(maxDepth(treeNode));
	}
	public static int maxDepth(TreeNode root) {
		return (root!=null)?Math.max(maxDepth(root.left), maxDepth(root.right))+1:0;
	}

}

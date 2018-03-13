package solution.hundred_twohundred;
/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of 
 * every node never differ by more than 1.
 * Example 1:
 * Given the following tree [3,9,20,null,null,15,7]:
    3
   / \
  9  20
    /  \
   15   7
 *Return true.
 *Example 2:
 *Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
 *Return false.
 * @author zy
 *
 */
public class One1Zero {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(-2);
		treeNode.right=new TreeNode(0);
		treeNode.left=new TreeNode(3);
		treeNode.left.left=new TreeNode(3);
//		treeNode.left.left.left=new TreeNode(3);
//		treeNode.left.left.left.left=new TreeNode(3);
		System.out.println(isBalanced(treeNode));
		System.out.println(height(treeNode));

	}
	public static  boolean isBalanced(TreeNode root) {
		return height(root)!=-1;
	}
	/**
	 * computer the height of the tree
	 * @param root
	 * @return
	 */
	private static int height(TreeNode root) {
		if(root==null) {
			return 0;
		}
		int left=height(root.left);
		if(left==-1) {
			return -1;
		}
		int right=height(root.right);
		if(right==-1) {
			return -1;
		}
		if(Math.abs(left-right)>1) {
			return -1;
		}
		return Math.max(left, right)+1;
	}

}

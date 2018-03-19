package solution.first_hunderd;
import java.util.Stack;
/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
 *Example 2:
    1
   / \
  2   3
 *Binary tree [1,2,3], return false.
 * @author zy
 *
 */
public class NineEight {
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(2);
		treeNode.right=new TreeNode(3);
		treeNode.left=new TreeNode(1);
		System.out.println(isValidBST(treeNode));	
	}

	public static boolean isValidBST(TreeNode root) {
		if(root==null) {
			return true;
		}
		TreeNode pre=null;
		Stack<TreeNode> sk=new Stack<>();
		while(root!=null||!sk.isEmpty()) {
			while(root!=null) {
				sk.push(root);
				root=root.left;
			}
			root=sk.pop();
			if(pre!=null&&pre.val>=root.val) {
				return false;
			}
			pre=root;
			root=root.right;
		}
		return true;
	}
}

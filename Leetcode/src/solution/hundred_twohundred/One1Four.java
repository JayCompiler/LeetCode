package solution.hundred_twohundred;

import java.util.ArrayList;
import java.util.Stack;
/**
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,Given
         1
        / \
       2   5
      / \   \
     3   4   6
 *The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * @author JayMining
 *
 */
public class One1Four {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(2);
		treeNode.left = new TreeNode(1);
		treeNode.right = new TreeNode(3);
		treeNode.left.left = new TreeNode(5);
		treeNode.left.right = new TreeNode(7);
		treeNode.right.left = new TreeNode(9);
		treeNode.right.right = new TreeNode(20);
		flatten(treeNode);
	}

	public static void flatten(TreeNode root) {
		ArrayList<TreeNode> al = preorderTraverse(root, new ArrayList<TreeNode>());
		if(al==null) {
			return;
		}
		root = al.get(0);
		for (int i = 1; i < al.size(); i++) {
			root.right = al.get(i);
			root.left=null;
			root = root.right;
		}
	}

	public static ArrayList<TreeNode> preorderTraverse(TreeNode root, ArrayList<TreeNode> a) {
		if (root == null) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				a.add(root);
				stack.push(root);
				root = root.left;
			}
			root = stack.pop().right;
		}
		return a;
	}
}

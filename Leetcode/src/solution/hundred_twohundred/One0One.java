package solution.hundred_twohundred;
/**
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
 * @author zy
 *
 */
public class One0One {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(-2);
		treeNode.right = new TreeNode(0);
		treeNode.left = new TreeNode(3);
		treeNode.left.left = new TreeNode(3);
		System.out.println(isSymmetric(treeNode));
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return help(root.left, root.right);
	}

	private static boolean help(TreeNode p, TreeNode q) {
		if (p == null) {
			return q == null;
		}
		if (q == null) {
			return p == null;
		}
		return (p.val == q.val) && help(p.left, q.right) && help(p.right, q.left);
	}

}

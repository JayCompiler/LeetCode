package solution.hundred_twohundred;
/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:
 *You may assume that duplicates do not exist in the tree.
 *For example, given
 *inorder = [9,3,15,20,7]
 *postorder = [9,15,7,20,3]
 *Return the following binary tree:
 *
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * @author zy
 *
 */
public class One0Six {

	public static void main(String[] args) {
		int[] postorder = { 9,15,7,20,3 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		TreeNode reS=buildTree(inorder, postorder);
		print(reS);
	}
	
	/**
	 * print tree
	 * @param reS
	 */
	private static void print(TreeNode reS) {
		if (reS == null) {
			return;
		}
		System.out.print(reS.val + " ");
		if (reS.left != null) {
			print(reS.left);
		}
		if (reS.right != null) {
			print(reS.right);
		}

	}
	/**
	 * construct the tree using postorder and inorder
	 * @param postorder
	 * @param inorder
	 * @return
	 */
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder.length == 0) {
			return null;
		}
		TreeNode reS = new TreeNode(postorder[postorder.length-1]);
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == postorder[postorder.length-1]) {
				int leftlen = i;
				int rightlen = inorder.length - i - 1;
				if (leftlen != 0) {
					int[] tempostleft = new int[leftlen];
					int[] tempinleft = new int[leftlen];
					System.arraycopy(postorder, 0, tempostleft, 0, leftlen);
					System.arraycopy(inorder, 0, tempinleft, 0, leftlen);
					reS.left = buildTree(tempinleft,tempostleft);
				}
				if (rightlen != 0) {
					int[] tempostright = new int[rightlen];
					int[] tempinright = new int[rightlen];
					System.arraycopy(postorder, 0 + leftlen, tempostright, 0, rightlen);
					System.arraycopy(inorder, 0 + leftlen + 1, tempinright, 0, rightlen);
					reS.right = buildTree(tempinright,tempostright);
				}
			}
		}
		return reS;
	}
}

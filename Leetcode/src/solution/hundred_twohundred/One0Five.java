package solution.hundred_twohundred;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree. For example,
 * given preorder = [3,9,20,15,7] inorder = [9,3,15,20,7] Return the following
 * binary tree: 3 / \ 9 20 / \ 15 7
 * 
 * @author zy
 *
 */
public class One0Five {

	public static void main(String[] args) {
		/*int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };*/
		int[] preorder = {};
		int[] inorder = {};
		TreeNode reS = buildTree(preorder, inorder);
		print(reS);
	}

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

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		TreeNode reS = new TreeNode(preorder[0]);
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[0]) {
				int leftlen = i;
				int rightlen = inorder.length - i - 1;
				if (leftlen != 0) {
					int[] tempreleft = new int[leftlen];
					int[] tempinleft = new int[leftlen];
					System.arraycopy(preorder, 1, tempreleft, 0, leftlen);
					System.arraycopy(inorder, 0, tempinleft, 0, leftlen);
					reS.left = buildTree(tempreleft, tempinleft);
				}
				if (rightlen != 0) {
					int[] tempreright = new int[rightlen];
					int[] tempinright = new int[rightlen];
					System.arraycopy(preorder, 1 + leftlen, tempreright, 0, rightlen);
					System.arraycopy(inorder, 0 + leftlen + 1, tempinright, 0, rightlen);
					reS.right = buildTree(tempreright, tempinright);
				}
			}
		}
		return reS;
	}

}

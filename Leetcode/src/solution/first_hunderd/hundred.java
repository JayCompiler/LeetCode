package solution.first_hunderd;
/**
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical 
 * and the nodes have the same value.
 * Example 1:
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
        [1,2,3],   [1,2,3]

	Output: true
	Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
 * @author zy
 *
 */
public class hundred {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(-2);
		treeNode.right=new TreeNode(0);
		treeNode.left=new TreeNode(3);
		treeNode.left.left=new TreeNode(3);
		TreeNode treeNode1 = new TreeNode(-2);
		treeNode1.right=new TreeNode(0);
		treeNode1.left=new TreeNode(3);
		treeNode1.left.left=new TreeNode(2);
		System.out.println(isSameTree(treeNode, treeNode1));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null) {
			return q==null;
		}
		if(q==null) {
			return p==null;
		}
		return (p.val==q.val)&&isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
	}

}

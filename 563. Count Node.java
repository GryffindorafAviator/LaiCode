// Easy
// Find the number of tree nodes.

// Examples:

//         5

//       /    \

//     3        8

//   /   \        \

// 1      4        11

// The number of above binary tree is 6.

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftCnt = countNodes(root.left);
    int rightCnt = countNodes(root.right);
    int cnt = leftCnt + rightCnt + 1;

    return cnt;
  }
}

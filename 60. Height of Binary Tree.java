// Easy
// Find the height of binary tree.

// Examples:

//         5

//       /    \

//     3        8

//   /   \        \

// 1      4        11

// The height of above binary tree is 3.

// How is the binary tree represented?

// We use the level order traversal sequence with a special symbol "#" denoting the null node.

// For Example:
// The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

//     1

//   /   \

//  2     3

//       /

//     4  
 
// Solution
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
  public int findHeight(TreeNode root) {
     if (root == null) {
      return 0;
    }

    int leftHeight = findHeight(root.left);
    int rightHeight = findHeight(root.right);
    int height = Math.max(leftHeight, rightHeight) + 1;

    return height;
  }
}

// Easy
// Check if two given binary trees are identical. 
// Identical means the equal valued keys are at the same position in the two binary trees.

// Examples
//         5

//       /    \

//     3        8

// and

//         5

//       /    \

//     3        8

// are identical trees.

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
  public boolean isIdentical(TreeNode one, TreeNode two) {
    if (one == null) {
      return two == null ? true : false;
    }

    if (two == null) {
      return false;
    }

    if (one.key != two.key) {
      return false;
    }

    boolean left = isIdentical(one.left, two.left);
    boolean right = isIdentical(one.right, two.right);
    
    return left && right;
  }
}
// TC: O(n); SC: O(lgn)

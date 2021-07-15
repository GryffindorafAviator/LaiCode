// Medium
// Given a binary tree in which each node contains an integer number. 
// Find the maximum possible path sum from a leaf to root.

// Assumptions

// The root of given binary tree is not null.

// Examples

//          10

//        /      \

//     -2        7

//   /     \

// 8      -4

// The maximum path sum is 10 + 7 = 17.

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
  public int maxPathSumLeafToRoot(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = maxPathSumLeafToRoot(root.left);
    int right = maxPathSumLeafToRoot(root.right);

    if (root.left == null) {
      return right + root.key;
    }
    else if (root.right == null) {
      return left + root.key;
    }
    else {
      return Math.max(left + root.key, right + root.key);
    }
  }
}

// TC: O(n), SC: O(height)

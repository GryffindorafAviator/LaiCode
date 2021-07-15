// Medium
// Given a binary tree in which each node contains an integer number. 
// Find the maximum possible sum from one leaf node to another leaf node. 
// If there is no such path available, 
// return Integer.MIN_VALUE(Java)/INT_MIN (C++).

// Examples

//   -15

//   /    \

// 2      11

//      /    \

//     6     14

// The maximum path sum is 6 + 11 + 14 = 31.

// How is the binary tree represented?

// We use the level order traversal sequence with a special symbol "#" denoting the null node.

// For Example:

// The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

//     1

//   /   \

//  2     3

//       /

//     4

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
  public int maxPathSum(TreeNode root) {
    int[] result = new int[]{Integer.MIN_VALUE};

    helper(root, result);

    return result[0];
  }

  private int helper(TreeNode root, int[] result) {
    if (root == null) {
      return 0;
    }

    int left = helper(root.left, result);
    int right = helper(root.right, result);

    if (root.left == null) {
      return right + root.key;
    }
    else if (root.right == null) {
      return left + root.key;
    }
    else {
      int sum = right + left + root.key;

      if (sum > result[0]) {
        result[0] = sum;
      }

      return Math.max(left, right) + root.key;
    }
  }
}

// TC: O(n), SC: O(height)

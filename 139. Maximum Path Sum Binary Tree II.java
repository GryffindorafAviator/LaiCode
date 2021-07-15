// Hard
// Given a binary tree in which each node contains an integer number. 
// Find the maximum possible sum from any node to any node (the start node and the end node can be the same). 

// Assumptions

// The root of the given binary tree is not null
// Examples

//    -1

//   /    \

// 2      11

//      /    \

//     6    -14

// one example of paths could be -14 -> 11 -> -1 -> 2

// another example could be the node 11 itself

// The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18

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
    int sum = left + right + root.key;
    int leftSum = left + root.key;
    int rightSum = right + root.key;
    int partialMax = Math.max(root.key, Math.max(leftSum, rightSum));

    result[0] = Math.max(result[0], Math.max(partialMax, sum));

    return partialMax;
  }
}

// TC: O(n), SC: O(height)

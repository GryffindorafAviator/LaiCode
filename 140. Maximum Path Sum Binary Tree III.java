// Medium
// Given a binary tree in which each node contains an integer number. 
// Find the maximum possible subpath sum(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, 
// and the subpath is allowed to contain only one node).

// Assumptions

// The root of given binary tree is not null
// Examples

//    -5

//   /    \

// 2      11

//      /    \

//     6     14

//            /

//         -3

// The maximum path sum is 11 + 14 = 25

// How is the binary tree represented?

// We use the level order traversal sequence with a special symbol "#" denoting the null node.

// For Example:

// The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

//     1

//   /   \

//  2     3

//       /

//     4

// Solution 1
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
    Set<Integer> prefixSum = new HashSet<>();
    int[] max = new int[]{Integer.MIN_VALUE};

    prefixSum.add(0);

    helperMax(root, prefixSum, 0, max);

    return max[0];
  }

  private void helperMax(TreeNode root, Set<Integer> prefixSum, int preSum, int[] max) {
    preSum += root.key;

    Iterator numSet = prefixSum.iterator();

    while (numSet.hasNext()) {
      int temp = preSum - (int) numSet.next();

      if (temp > max[0]) {
        max[0] = temp;
      }
    }

    boolean needRemove = prefixSum.add(preSum);

    if (root.left != null) {
      helperMax(root.left, prefixSum, preSum, max);
    }

    if (root.right != null) {
      helperMax(root.right, prefixSum, preSum, max);
    }

    if (needRemove) {
      prefixSum.remove(preSum);
    }

    return;
  }
}
// TC: O(n^2), SC: O(n)

// Solution 2
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
    int[] max = new int[]{Integer.MIN_VALUE};

    helperMax(root, max);

    return max[0];
  }

  private int helperMax(TreeNode root, int[] max) {
    if (root == null) {
      return 0;
    }

    int left = helperMax(root.left, max);
    int right = helperMax(root.right, max);
    int temp = Math.max(Math.max(left, right), 0) + root.key;

    max[0] = Math.max(max[0], temp);

    return temp;
  }
}
// TC: O(n), SC: O(1)

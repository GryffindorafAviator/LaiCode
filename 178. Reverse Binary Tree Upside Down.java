// Medium
// Given a binary tree where all the right nodes are leaf nodes, 
// flip it upside down and turn it into a tree with left leaf nodes as the root.

// Examples

//         1

//       /    \

//     2        5

//   /   \

// 3      4

// is reversed to

//         3

//       /    \

//     2        4

//   /   \

// 1      5
  
// Solution 1, recursion
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
  public TreeNode reverse(TreeNode root) {
    if (root == null || root.left == null) {
      return root;
    }

    TreeNode newHead = reverse(root.left);

    root.left.left = root;
    root.left.right = root.right;
    root.left = null;
    root.right = null;

    return newHead;
  }
}

// TC: O(n); SC: O(n)

// Solution 2, iteration
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
  public TreeNode reverse(TreeNode root) {
    if (root == null || root.left == null) {
      return root;
    }
 
    TreeNode prev = null;
    TreeNode prevRight = null;

    while (root != null) {
      TreeNode next = root.left;
      TreeNode right = root.right;

      root.left = prev;
      root.right = prevRight;
      prevRight = right;
      prev = root;
      root = next;
    }

    return prev;
  }
}

// TC: O(n); SC: O(1)

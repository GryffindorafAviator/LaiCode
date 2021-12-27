// Medium
// Given the postorder traversal sequence of a binary search tree, 
// reconstruct the original tree.

// Assumptions
// The given sequence is not null
// There are no duplicate keys in the binary search tree

// Examples
// postorder traversal = {1, 4, 3, 11, 8, 5}
// the corresponding binary search tree is

//         5

//       /    \

//     3        8

//   /   \        \

// 1      4        11

// How is the binary tree represented?
// We use the pre order traversal sequence with a special symbol "#" denoting the null node.

// For Example:
// The sequence [1, 2, #, #, 3, 4, #, #, #] represents the following binary tree:

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
  public TreeNode reconstruct(int[] post) {
    if (post == null || post.length == 0) {
      return null;
    }

    int[] idx = new int[] {post.length - 1};

    return helper(post, idx, Integer.MIN_VALUE);
  }

  private TreeNode helper(int[] post, int[] idx, int min) {
    if (idx[0] < 0 || post[idx[0]] < min) {
      return null;
    }

    TreeNode root = new TreeNode(post[idx[0]]);
    idx[0]--;

    root.right = helper(post, idx, root.key);
    root.left = helper(post, idx, min); // min = root.parent.key

    return root;
  }
}
// TC: O(n); 
// SC: avg, O(logn); worst, O(n)

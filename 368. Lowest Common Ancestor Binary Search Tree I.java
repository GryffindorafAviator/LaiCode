// Easy
// Given two keys in a binary search tree, 
// find their lowest common ancestor.

// Assumptions

// There is no parent pointer for the nodes in the binary search tree

// There are no duplicate keys in the binary search tree

// The given two nodes are guaranteed to be in the binary search tree

// Examples

//         5

//       /   \

//      2     12

//    /  \      \

//   1    3      14

// The lowest common ancestor of 1 and 14 is 5

// The lowest common ancestor of 1 and 3 is 2

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

// Solution 1
public class Solution {
  public TreeNode lca(TreeNode root, int p, int q) {
    if (root == null || root.key == p || root.key == q) {
      return root;
    }

    TreeNode left = lca(root.left, p, q);
    TreeNode right = lca(root.right, p, q);

    if (left != null && right != null) {
      return root;
    }
    else {
      return left == null ? right : left;
    }
  }
}

// TC: O(n), SC: O(1).

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
  public TreeNode lca(TreeNode root, int p, int q) {
    int small = Math.min(p, q);
    int large = Math.max(p, q);

    while (root != null) {
      if (root.key < small) {
        root = root.right;
      }
      else if (root.key > large) {
        root = root.left;
      }
      else {
        return root;
      }
    }

    return null;
  }
}

// TC: O(logn), SC: O(1).

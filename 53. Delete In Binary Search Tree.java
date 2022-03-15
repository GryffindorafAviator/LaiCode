// Medium
// Delete the target key K in the given binary search tree if the binary search tree contains K. 
// Return the root of the binary search tree.

// Find your own way to delete the node from the binary search tree, 
// after deletion the binary search tree's property should be maintained.

// Assumptions

// There are no duplicate keys in the binary search tree

// The smallest larger node is first candidate after deletion

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
  public TreeNode deleteTree(TreeNode root, int key) {
    if (root == null) {
      return root;
    }

    if (root.key == key) {
      if (root.left == null && root.right == null) {
        root = null;
      }
      else if (root.left == null) {
        root = root.right;
      }
      else if (root.right == null) {
        root = root.left;
      }
      else if (root.right.left == null) {
        root.right.left = root.left;
        root = root.right;
      }
      else {
        TreeNode newRoot = findSmallest(root.right);
        newRoot.left = root.left;
        newRoot.right = root.right;
        return newRoot;
      }
    }
    else if (root.key < key) {
      root.right = deleteTree(root.right, key);
    }
    else {
      root.left = deleteTree(root.left, key);
    }

    return root;
  }

  private TreeNode findSmallest(TreeNode root) {
    TreeNode prev = root;

    while (root.left != null) {
      prev = root;
      root = root.left;
    }

    prev.left = root.right;
    return root;
  }
}

// TC: O(height), SC: O(height)

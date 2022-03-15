// Medium
// Determine if a given binary tree is binary search tree.There should no be duplicate keys in binary search tree.

// Assumptions

// You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.
// Corner Cases

// What if the binary tree is null? Return true in this case.
 
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
  public boolean isBST(TreeNode root) {
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;

    return isBSTHelper(root, min, max);
  }

  private boolean isBSTHelper(TreeNode root, int min, int max) {
    if (root == null) {
      return true;
    }
    else if (root.key <= min || root.key >= max) {
      return false;
    }
    else {
      return (isBSTHelper(root.left, min, root.key)) && (isBSTHelper(root.right, root.key, max));
    }
  }
}

// TC: O(n), SC: O(height)

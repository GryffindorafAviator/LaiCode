// Medium
// Check if a given binary tree is balanced. 
// A balanced binary tree is one in which the depths of every node’s left and right subtree differ by at most 1.

// Examples

//         5

//       /    \

//     3        8

//   /   \        \

// 1      4        11

// is balanced binary tree,

//         5

//       /

//     3

//   /   \

// 1      4

// is not balanced binary tree.

// Corner Cases
// What if the binary tree is null? Return true in this case.
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
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);

    if (isBalanced(root.left) && isBalanced(root.right) && (Math.abs(leftHeight - rightHeight) <= 1)) {
      return true;
    }

    return false;
  }

  private int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    int height = Math.max(leftHeight, rightHeight) + 1;

    return height;
  }
}

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
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    return height(root) != -1;
  }

  private int height(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int leftHeight = height(root.left);
 
    if (leftHeight == -1) {
      return -1;
    }

    int rightHeight = height(root.right);

    if (rightHeight == -1) {
      return -1;
    }

    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }

    return Math.max(leftHeight, rightHeight) + 1;
  }
}

// Hard
// Given two nodes in a binary tree, 
// find their lowest common ancestor (the given two nodes are not guaranteed to be in the binary tree).

// Return null If any of the nodes is not in the tree.

// Assumptions
// There is no parent pointer for the nodes in the binary tree.
// The given two nodes are not guaranteed to be in the binary tree.

// Examples
//         5

//       /   \

//      9     12

//    /  \      \

//   2    3      14

// The lowest common ancestor of 2 and 14 is 5
// The lowest common ancestor of 2 and 9 is 9
// The lowest common ancestor of 2 and 8 is null (8 is not in the tree)

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
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
        if (!checkNode(root, one) || !checkNode(root, two)) {
          return null;
        }
    return lcaHelper(root, one, two);
  }

  private TreeNode lcaHelper(TreeNode node, TreeNode one, TreeNode two) {
    if (node == null) {
      return null;
    }
    if (node == one || node == two) {
      return node;
    }

    TreeNode left = lcaHelper(node.left, one, two);
    TreeNode right = lcaHelper(node.right, one, two);

    if (left != null && right != null) {
      return node;
    }
    else if (left != null) {
      return left;
    }
    else if (right != null) {
      return right;
    }
    else {
      return null;
    }
  }

  private boolean checkNode(TreeNode node, TreeNode target) {
    if (node == null) {
      return false;
    }
    if (node == target) {
      return true;
    }
    return checkNode(node.left, target) || checkNode(node.right, target);
  }
}
// TC: O(n); SC: O(height)

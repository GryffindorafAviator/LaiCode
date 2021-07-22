// Medium
// Given a binary tree, 
// flatten it to a linked list in-place.

// For example,
// Given

//          1
//         / \
//        2   5
//       / \   \
//      3   4   6
// The flattened tree should look like:

//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6

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
  public TreeNode flatten(TreeNode root) {
    TreeNode[] curr = new TreeNode[1];

    helperFlatten(root, curr);

    return root;
  }

  private void helperFlatten(TreeNode root, TreeNode[] curr) {
    if (root == null) {
      return;
    }

    TreeNode leftNode = root.left;
    TreeNode rightNode = root.right;

    if (curr[0] != null) {
      curr[0].right = root;
    }

    curr[0] = root;
    curr[0].left = null;

    helperFlatten(leftNode, curr);
    helperFlatten(rightNode, curr);
  }
}
// TC: O(n), SC: O(height)

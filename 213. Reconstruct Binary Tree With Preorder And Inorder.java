// Medium
// Given the preorder and inorder traversal sequence of a binary tree, 
// reconstruct the original tree.

// Assumptions

// The given sequences are not null and they have the same length
// There are no duplicate keys in the binary tree
// Examples

// preorder traversal = {5, 3, 1, 4, 8, 11}

// inorder traversal = {1, 3, 4, 5, 8, 11}

// the corresponding binary tree is

//         5

//       /    \

//     3        8

//   /   \        \

// 1      4        11

// How is the binary tree represented?

// We use the pre order traversal sequence with a special symbol "#" denoting the null node.

// For Example:

// The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:

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
  public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
    Map<Integer, Integer> inIndex = new HashMap<>();
    

    for (int i = 0; i < inOrder.length; ++i) {
      inIndex.put(inOrder[i], i);
    }

    return helper(preOrder, 0, inOrder.length - 1, 0, preOrder.length - 1, inIndex);
  }

  private TreeNode helper(int[] preOrder, int inLeft, int inRight, int preLeft, int preRight, Map<Integer, Integer> inIndex) {
    if (inLeft > inRight) {
      return null;
    }

    TreeNode root = new TreeNode(preOrder[preLeft]);
    int rootIndex = inIndex.get(preOrder[preLeft]);

    root.left = helper(preOrder, inLeft, rootIndex - 1, preLeft + 1, preLeft + rootIndex - inLeft, inIndex);
    root.right = helper(preOrder, rootIndex + 1, inRight, preLeft + rootIndex - inLeft + 1, preRight, inIndex);

    return root;
  }
}
// TC: O(n), SC: O(n + logn) = O(n)

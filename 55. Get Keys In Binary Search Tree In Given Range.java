// Easy
// Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, both min and max are inclusive.

// Examples

//         5

//       /    \

//     3        8

//   /   \        \

//  1     4        11

// get the keys in [2, 5] in ascending order, result is  [3, 4, 5]

// Corner Cases

// What if there are no keys in the given range? Return an empty list in this case.
// How is the binary tree represented?

// We use the level order traversal sequence with a special symbol "#" denoting the null node.

// For Example:

// The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

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
  public List<Integer> getRange(TreeNode root, int min, int max) {
    List<Integer> ansList = new ArrayList<Integer>();
    getRangeHelper(root, min, max, ansList);
    return ansList;
  }

  private void getRangeHelper(TreeNode root, int min, int max, List<Integer> ansList) {
    if (root == null) {
      return;
    }

    if (root.key > min) {
      getRangeHelper(root.left, min, max, ansList);
    }

    if (root.key >= min && root.key <= max) {
      ansList.add(root.key);
    }

    if (root.key < max) {
      getRangeHelper(root.right, min, max, ansList);
    }
  }
}
 

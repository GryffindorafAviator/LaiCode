// Medium
// Check if a given binary tree is completed. A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. Furthermore, all nodes are as far left as possible.

// Examples

//         5

//       /    \

//     3        8

//   /   \

// 1      4

// is completed.

//         5

//       /    \

//     3        8

//   /   \        \

// 1      4        11

// is not completed.

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
  public boolean isCompleted(TreeNode root) {
    if (root == null) {
      return true;
    }
    
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    boolean flag = false;

    while (!q.isEmpty()) {
      root = q.poll();

      if (root.left == null) {
        flag = true;
      }
      else if (flag) {
        return false;
      }
      else {
        q.offer(root.left);
      }

      if (root.right == null) {
        flag = true;
      }
      else if (flag) {
        return false;
      }
      else {
        q.offer(root.right);
      }
    }

    return true;
  }
}

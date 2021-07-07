// Medium
// Get the list of keys in a given binary tree layer by layer in zig-zag order.

// Examples

//         5

//       /    \

//     3        8

//   /   \        \

//  1     4        11

// the result is [5, 3, 8, 11, 4, 1]

// Corner Cases

// What if the binary tree is null? Return an empty list in this case.
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
  public List<Integer> zigZag(TreeNode root) {
    if (root == null) {
      return new LinkedList<Integer>();
    }

    List<Integer> result = new LinkedList<>();
    Deque<TreeNode> deque = new LinkedList<>();
    deque.offerFirst(root);
    boolean isEven = true;

    while (!deque.isEmpty()) {
      int size = deque.size();

      for (int i = 0; i < size; ++i) {
        if (isEven) {
          TreeNode temp = deque.pollFirst();
          result.add(temp.key);

          if (temp.right != null) {
            deque.offerLast(temp.right);
          }

          if (temp.left != null) {
            deque.offerLast(temp.left);
          } 
        }
        else {
          TreeNode temp = deque.pollLast();
          result.add(temp.key);

          if (temp.left != null) {
            deque.offerFirst(temp.left);
          }

          if (temp.right != null) {
            deque.offerFirst(temp.right);
          }
        }
      }

      isEven = !isEven;   
    }

    return result;    
  }
}

// TC: O(n), SC: O(n).

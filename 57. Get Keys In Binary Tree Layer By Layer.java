// Easy
// Get the list of list of keys in a given binary tree layer by layer. 
// Each layer is represented by a list of keys and the keys are traversed from left to right.

// Examples

//         5

//       /    \

//     3        8

//   /   \        \

//  1     4        11

// the result is [ [5], [3, 8], [1, 4, 11] ]

// Corner Cases
// What if the binary tree is null? 
// Return an empty list of list in this case.

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
  public List<List<Integer>> layerByLayer(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();

    if (root == null) {
      return ans;
    }

    Queue<TreeNode> q = new ArrayDeque<>();
    
    q.offer(root);

    while (!q.isEmpty()) {
      int len = q.size();
      List<Integer> temp = new ArrayList<>();

      for (int i = 0; i < len; ++i) {
        root = q.poll();

        if (root.left != null) {
          q.offer(root.left);
        }

        if (root.right != null) {
          q.offer(root.right);
        }

        temp.add(root.key);
      }

      ans.add(temp);
    }

    return ans;
  }
}
      

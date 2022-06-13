// Medium
// Implement an iterative, 
// in-order traversal of a given binary tree, 
// return the list of keys of each node in the tree as it is in-order traversed.

// Examples

//         5

//       /    \

//     3        8

//   /   \        \

// 1      4        11

// In-order traversal is [1, 3, 4, 5, 8, 11]

// Corner Cases
// What if the given binary tree is null? 
// Return an empty list in this case.
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
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;

    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        stack.offerFirst(cur);
        cur = cur.left;
      }
      else {
        cur = stack.pollFirst();
        ans.add(cur.key);
        cur = cur.right;
      }
    }

    return ans;
  }
}
// TC: O(n); 
// SC: avg, O(logn); worst, O(n)

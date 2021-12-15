// Medium
// In a binary search tree, 
// find k nodes containing the closest numbers to the given target number. 
// return them in sorted array

// Assumptions:

// The given root is not null.
// There are no duplicate keys in the binary search tree.
  
// Examples:

//     5

//   /    \

// 2      11

//      /    \

//     6     14

// closest number to 4 is 5

// closest number to 10 is 11

// closest number to 6 is 6

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
  public int[] closestKValues(TreeNode root, double target, int k) {
    if (root == null) {
      return new int[k];
    }

    Deque<TreeNode> deque = new ArrayDeque<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;

    for (int i = 0; i < k; i++) {
      
    } 

    while (cur != null || !stack.isEmpty()) {
      int cnt = deque.size();

      if (cur != null) {
        stack.offerFirst(cur);
        cur = cur.left;
      }
      else {
        cur = stack.pollFirst();

        if (cnt == k) {
          if (Math.abs(cur.key - target) >= Math.abs(deque.peekLast().key - target)) {
            break;
          }
          else {
            deque.pollLast();
          }
        }

        deque.offerFirst(cur);
        cur = cur.right;
      }
    }

    int i = 0;
    int[] ans = new int[deque.size()];

    while (!deque.isEmpty()) {
        ans[i] = deque.pollLast().key;
        i++;
      }

      return ans;
  }
}

// TC: O(n); SC: O(k)

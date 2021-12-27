// Hard
// Implement an iterative, 
// post-order traversal of a given binary tree, 
// return the list of keys of each node in the tree as it is post-order traversed.

// Examples

//         5

//       /    \

//     3        8

//   /   \        \

// 1      4        11

// Post-order traversal is [1, 4, 3, 11, 8, 5]

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
  public List<Integer> postOrder(TreeNode root) {
    List<Integer> ans = new ArrayList<>();

    if (root == null) {
      return ans;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode prev = null;
    
    stack.offerFirst(root);

    while (!stack.isEmpty()) {
      TreeNode curr = stack.peekFirst();

      if (prev == null || curr == prev.left || curr == prev.right) {
        if (curr.left != null) {
          stack.offerFirst(curr.left);
        }
        else if (curr.right != null) {
          stack.offerFirst(curr.right);
        }
        else {
          stack.pollFirst();
          ans.add(curr.key);
        }  
      }
      else if (prev == curr.left && curr.right != null) {
        stack.offerFirst(curr.right);
      }
      else {
        curr = stack.pollFirst();
        ans.add(curr.key);
      }

      prev = curr;
    }

    return ans;
  }
}
// TC: O(n); 
// SC: avg, O(logn); worst, O(n)

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
  public List<Integer> postOrder(TreeNode root) {
    List<Integer> ans = new ArrayList<>();

    if (root == null) {
      return ans;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();

    stack.offerFirst(root);

    while (!stack.isEmpty()) {
      TreeNode cur = stack.pollFirst();
      ans.add(cur.key);

      if (cur.left != null) {
        stack.offerFirst(cur.left);
      }

      if (cur.right != null) {
        stack.offerFirst(cur.right);
      }
    }

    Collections.reverse(ans);

    return ans;
  }
}
//  TC: O(n); SC: O(logn)

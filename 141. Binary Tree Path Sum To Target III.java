// Medium
// Given a binary tree in which each node contains an integer number. 
// Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), 
// the sum of the numbers on the path is the given target number.

// Examples

//     5

//   /    \

// 2      11

//      /    \

//     6     14

//   /

//  3

// If target = 17, There exists a path 11 + 6, the sum of the path is target.

// If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.

// If target = 10, There does not exist any paths sum of which is target.

// If target = 11, There exists a path only containing the node 11.

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
  public boolean exist(TreeNode root, int target) {
    if (root == null) {
      return false;
    }

    List<TreeNode> path = new ArrayList<TreeNode>();

    return helperDFS(root, target, path);
  }

  private boolean helperDFS(TreeNode root, int target, List<TreeNode> path) {
    path.add(root);

    int sum = 0;

    for (int i = path.size() - 1; i >= 0; --i) {
      sum += path.get(i).key;

      if (sum == target) {
        return true;
      }
    }

    if (root.left != null && helperDFS(root.left, target, path)) {
      return true;
    }
    
    if (root.right != null && helperDFS(root.right, target, path)) {
      return true;
    }

    path.remove(path.size() - 1);

    return false;
  }
}
// TC: O(n^2), SC: O(height)

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
  public boolean exist(TreeNode root, int target) {
    if (root == null) {
      return false;
    }

    Set<Integer> prefixSum = new HashSet<>();
    prefixSum.add(0);

    return helperDFS(root, target, prefixSum, 0);
  }

  private boolean helperDFS(TreeNode root, int target, Set<Integer> prefixSum, int preSum) {
    preSum += root.key;

    if (prefixSum.contains(preSum - target)) {
      return true;
    }

    boolean needRemove = prefixSum.add(preSum);
    
    if (root.left != null && helperDFS(root.left, target, prefixSum, preSum)) {
      return true;
    }

    if (root.right != null && helperDFS(root.right, target, prefixSum, preSum)) {
      return true;
    }

    if (needRemove) {
      prefixSum.remove(preSum);
    }

    return false;
  }
}
// TC: O(n), SC: O(n)

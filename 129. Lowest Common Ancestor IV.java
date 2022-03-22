// Hard
// Given K nodes in a binary tree, 
// find their lowest common ancestor.

// Assumptions
// K >= 2
// There is no parent pointer for the nodes in the binary tree
// The given K nodes are guaranteed to be in the binary tree

// Examples

//         5

//       /   \

//      9     12

//    /  \      \

//   2    3      14

// The lowest common ancestor of 2, 3, 14 is 5
// The lowest common ancestor of 2, 3, 9 is 9

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
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    if (root == null || nodes == null || nodes.size() == 0){
      return null;
    }

    Set<TreeNode> nodeSet = buildSet(nodes);

    TreeNode ans = helper(root, nodeSet);
    
    return ans;
  }

  private TreeNode helper(TreeNode root, Set<TreeNode> nodeSet) {
    if (root == null) {
      return null;
    }

    if (nodeSet.contains(root)) {
      return root;
    }

    TreeNode leftChild = helper(root.left, nodeSet);
    TreeNode rightChild = helper(root.right, nodeSet);

    if (leftChild != null && rightChild != null) {
      return root;
    }

    return leftChild == null ? rightChild : leftChild;
  }

  private Set<TreeNode> buildSet(List<TreeNode> nodes) {
    Set<TreeNode> nodeSet = new HashSet<>();

    for (TreeNode node : nodes) {
      nodeSet.add(node);
    }

    return nodeSet;
  }
}
// TC: O(n); SC: O(height)

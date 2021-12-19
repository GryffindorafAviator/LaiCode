// Medium
// Given two nodes in a K-nary tree, 
// find their lowest common ancestor.

// Assumptions
// -There is no parent pointer for the nodes in the K-nary tree.
// -The given two nodes are guaranteed to be in the K-nary tree.

// Examples

//         5

//       /   \

//      9   12

//    / | \      \

//  1 2   3      14
  
// The lowest common ancestor of 2 and 14 is 5.
// The lowest common ancestor of 2 and 9 is 9.
  
// Solution
/**
 * public class KnaryTreeNode {
 *     int key;
 *     List<KnaryTreeNode> children;
 *     public KnaryTreeNode(int key) {
 *         this.key = key;
 *         this.children = new ArrayList<>();
 *     }
 * }
 */
public class Solution {
  public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
    if (root == null || root == a || root == b) {
      return root;
    }

    KnaryTreeNode found = null;

    for (KnaryTreeNode chld : root.children) {
      KnaryTreeNode node = lowestCommonAncestor(chld, a, b);

      if (node == null) {
        continue;
      }

      if (found == null) {
        found = node;
      }
      else {
        return root;
      }
    }

    return found;
  }
}

// TC: O(n); SC:O(height)

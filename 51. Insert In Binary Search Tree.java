// Easy
// Insert a key in a binary search tree if the binary search tree does not already contain the key. 
// Return the root of the binary search tree.

// Assumptions
// There are no duplicate keys in the binary search tree
// If the key is already existed in the binary search tree, 
// you do not need to do anything

// Examples

//         5

//       /    \

//     3        8

//   /   \

//  1     4

// insert 11, the tree becomes

//         5

//       /    \

//     3        8

//   /   \        \

//  1     4       11

// insert 6, the tree becomes

//         5

//       /    \

//     3        8

//   /   \     /  \

//  1     4   6    11

// Solution 1, iterative
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
  public TreeNode insert(TreeNode root, int key) {
    if (root == null) {
      return new TreeNode(key);
    }

    TreeNode cur = root;

    while (cur.key != key) {
      if (key < cur.key) {
        if (cur.left == null) {
          cur.left = new TreeNode(key);
        }

        cur = cur.left;
      }
      else {
        if (cur.right == null) {
          cur.right = new TreeNode(key);
        }

        cur = cur.right;
      }
    }

    return root;
  }
}

// TC: avg, O(logn); worst, O(n)
// SC: O(1)

// Solution 2, recursive
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
  public TreeNode insert(TreeNode root, int key) {
    if (root == null) {
      return new TreeNode(key);
    }

    if (key < root.key) {
      root.left = insert(root.left, key);
    }
    else if (key > root.key) {
      root.right = insert(root.right, key);
    }

    return root;
  }
}

// TC: avg, O(logn); worst, O(n)
// SC: avg, O(logn); worst, O(n)

// Medium
// Given a binary tree, count the number of nodes in each node’s left subtree, and store it in the numNodesLeft field.

// Examples


//                   1(6)

//                /          \

//            2(3)        3(0)

//           /      \

//       4(1)     5(0)

//     /        \        \

// 6(0)     7(0)   8(0)

// The numNodesLeft is shown in parentheses.
/**
 * public class TreeNodeLeft {
 *   public int key;
 *   public TreeNodeLeft left;
 *   public TreeNodeLeft right;
 *   public int numNodesLeft;
 *   public TreeNodeLeft(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public void numNodesLeft(TreeNodeLeft root) {
    count(root);
  }

  private int count(TreeNodeLeft root) {
    if (root == null) {
      return 0;
    }

    int cntLeft = count(root.left);
    int cntRight = count(root.right);
    root.numNodesLeft = cntLeft;

    return cntLeft + cntRight + 1;
  }
}





// Draft
/**
 * public class TreeNodeLeft {
 *   public int key;
 *   public TreeNodeLeft left;
 *   public TreeNodeLeft right;
 *   public int numNodesLeft;
 *   public TreeNodeLeft(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public void numNodesLeft(TreeNodeLeft root) {
    if (root == null) {
      root.numNodesLeft = 0;
      return;
    }

    root.numNodesLeft = count(root.left);
    numNodesLeft(root.left);

    while () {
      
    }  
  }

  private int count(TreeNodeLeft root) {
    int cntLeft;
    int cntRight;

    if (root == null) {
      return 0;
    }
    else if (root.left == null && root.right == null) {
      cntLeft = 0;
      cntRight = 0;
    }
    else if (root.left == null) {
      cntLeft = 0;
      cntRight = count(root.right) + 1;
    }
    else if (root.right == null) {
      cntLeft = count(root.left) + 1;
      cntRight = 0;
    }
    else {
      cntLeft = count(root.left) + 1;
      cntRight = count(root.right) + 1;;
    }

    return cntLeft + cntRight;
  }
}

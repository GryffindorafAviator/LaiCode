// Medium
// Given the root of a binary tree, 
// determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:
// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
 
// Example 1:
// Input: root = [2,1,3]
// Output: true
  
// Example 2:
// Input: root = [5,1,4,null,null,3,6]
// Output: false
  
// Explanation: 
// The root node's value is 5 but its right child's value is 4.
 

// Constraints:
// The number of nodes in the tree is in the range [1, 104].
// -231 <= Node.val <= 231 - 1
  
// Solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> treeArr = new ArrayList<>();
        
        inOrder(root, treeArr);
        
        for (int i = 0; i < treeArr.size() - 1; i++) {
            if (treeArr.get(i) >= treeArr.get(i + 1)) {
                return false;
            }
        }
        
        return true;
    }
    
    private void inOrder(TreeNode root, List<Integer> treeArr) {
        if (root == null) {
            return;
        }
        
        inOrder(root.left, treeArr);
        treeArr.add(root.val);
        inOrder(root.right, treeArr);
    }
}
// TC: O(n); SC: O(n)
// Success
// Details 
// Runtime: 2 ms, faster than 23.02% of Java online submissions for Validate Binary Search Tree.
// Memory Usage: 45 MB, less than 5.97% of Java online submissions for Validate Binary Search Tree.

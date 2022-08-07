// Easy
// Return the number of nodes in the linked list.

// Examples
// L = null, return 0
// L = 1 -> null, return 1
// L = 1 -> 2 -> null, return 2
  
// Solution
/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public int numberOfNodes(ListNode head) {
    int cnt = 0;

    while (head != null) {
      cnt++;
      head = head.next;
    }

    return cnt;
  }
}
// TC: O(n); SC: O(1)

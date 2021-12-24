// Easy
// Remove all elements from a linked list of integers that have value val.

// Example
// Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
// Return: 1 --> 2 --> 3 --> 4 --> 5
  
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
  public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    
    while (head != null) {
      if (head.value == val) {
        prev.next = head.next;
      }
      else {
        prev = prev.next;
      }

      head = head.next;
    }

    return dummy.next;
  }
}
// TC: O(n); SC: O(1)

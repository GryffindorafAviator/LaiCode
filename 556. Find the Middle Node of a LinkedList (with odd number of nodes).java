// Easy
// Find the middle node of a given linked list with odd number length.

// Assumption: the length > 0

// Example: 
// L = 1 -> 2 -> 3 -> null, return 2->3

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
  public ListNode findMiddleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode fast = head;
    ListNode slow = head;

    while (fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }
}

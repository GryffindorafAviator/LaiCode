// Given a linked list, remove the nth node from the end of list and return its head.

// Assumptions
// If n is not valid, you do not need to do anything to the original list.
// Try to do this in one pass.

// Examples

// Given linked list: 1->2->3->4->5, and n = 2.

// After removing the second node from the end, the linked list becomes 1->2->3->5.

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
  private int remove(ListNode head, int n) {
    int curPos = head.next == null ? 0 : remove(head.next, n) + 1;
    if(curPos == n) {
      ListNode curr = head.next;
      ListNode next = curr == null ? null : head.next.next;
      head.next = next;
    }
    return curPos;
  }
  public ListNode removeNthFromEnd(ListNode head, int n) {
    // Write your solution here
    if(head == null) {
      return head;
    }
    int len = remove(head, n);
    if(len+1 == n) {
      head = head.next;
    }
    return head;
  }
}

// Medium
// Reverse pairs of elements in a singly-linked list.

// Examples

// L = null, after reverse is null
// L = 1 -> null, after reverse is 1 -> null
// L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
// L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null

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
  public ListNode reverseInPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode recordNode = reverseInPairs(head.next.next);
    ListNode newHead = head.next;
    head.next.next = head;
    head.next = recordNode;

    return newHead;
  }
}

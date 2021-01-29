// Debug
// There are bugs in the given code, please fix them.

// Reverse a singly-linked list.

// Examples

// L = null, return null
// L = 1 -> null, return 1 -> null
// L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null

public class Solution {
  public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}

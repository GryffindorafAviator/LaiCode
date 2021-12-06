// Easy
// Reverse a singly-linked list iteratively.

// Examples
// L = null, return null
// L = 1 -> null, return 1 -> null
// L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null

// Solution 1
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
  public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode pre = null;
    ListNode cur = head;
    ListNode nxt = null;

    while (cur != null) {
      nxt = cur.next;
      cur.next = pre;
      pre = cur;
      cur = nxt;
    }

    head = pre;

    return head;
  }
}

// Solution 2
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
  public ListNode reverse(ListNode head) {
    ListNode pre = null;

    while (head != null) {
      ListNode nxt = head.next;
      head.next = pre;
      pre = head;
      head = nxt;
    }

    return pre;
  }
}

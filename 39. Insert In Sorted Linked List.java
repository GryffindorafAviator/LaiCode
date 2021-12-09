// Easy
// Insert a value in a sorted linked list.

// Examples
// L = null, insert 1, return 1 -> null
// L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
// L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
// L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null

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
  public ListNode insert(ListNode head, int value) {
    ListNode val = new ListNode(value);
    ListNode cur = head;

    if (head == null) {
      return val;
    }

    if (value < head.value) {
      val.next = head;
      return val;
    }

    while (cur.next != null) {
      if (cur.value <= value && value <= cur.next.value) {
        val.next = cur.next;
        cur.next = val;

        return head;
      }

      cur = cur.next;
    }

    cur.next = val;

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
  public ListNode insert(ListNode head, int value) {
    ListNode val = new ListNode(value);

    if (head == null || value < head.value) {
      val.next = head;
      return val;
    }

    ListNode cur = head;

    while (cur.next != null && cur.next.value < value ) {
      cur = cur.next;
    }

    if (cur.next != null) {
        val.next = cur.next;
      }

    cur.next = val;

    return head;
  }
}

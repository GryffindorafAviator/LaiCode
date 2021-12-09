// Easy
// Merge two sorted lists into one large sorted list.

// Examples

// L1 = 1 -> 4 -> 6 -> null, L2 = 2 -> 5 -> null, merge L1 and L2 to 1 -> 2 -> 4 -> 5 -> 6 -> null
// L1 = null, L2 = 1 -> 2 -> null, merge L1 and L2 to 1 -> 2 -> null
// L1 = null, L2 = null, merge L1 and L2 to null

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
  public ListNode merge(ListNode one, ListNode two) {
    if (one == null) {
      return two;
    }

    if (two == null) {
      return one;
    }

    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    ListNode cur1 = one;
    ListNode cur2 = two;

    while (cur1 != null && cur2 != null) {
      if (cur1.value < cur2.value) {
        cur.next = cur1;
        cur1 = cur1.next;
      }
      else {
        cur.next = cur2;
        cur2 = cur2.next;
      }

      cur = cur.next;
    }

    if (cur1 != null) {
      cur.next = cur1;
    }

    if (cur2 != null) {
      cur.next = cur2;
    }

    ListNode head = dummy.next;

    return head;
  }
}

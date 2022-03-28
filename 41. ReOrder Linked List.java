// Hard
// Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

// Examples
// L = null, is reordered to null
// L = 1 -> null, is reordered to 1 -> null
// L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
// L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null
  
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
  public ListNode reorder(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode midTail = midNode(head);
    ListNode newHead = reverse(midTail.next);
    midTail.next = null;
    ListNode finalHead = head;
    ListNode curr = head;

    while (newHead != null) {
      ListNode next = curr.next;
      curr.next = newHead;
      newHead = newHead.next;
      curr = curr.next;
      curr.next = next;
      curr = curr.next;
    }

    return finalHead;
  }

  private ListNode midNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  private ListNode reverse(ListNode head) {
    ListNode prev = null;

    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }

    return prev;
  }
}

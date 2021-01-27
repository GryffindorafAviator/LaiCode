// Easy
// Insert a value in a sorted linked list.

// Assumption: 
// length > 1,  
// first node value <= inserting node value <= last node value 

// Example:
// 1 -> 3 -> null, 
// insert : 2 → return 1 -> 2 -> 3 -> null

// /**
//  * class ListNode {
//  *   public int value;
//  *   public ListNode next;
//  *   public ListNode(int value) {
//  *     this.value = value;
//  *     next = null;
//  *   }
//  * }
//  */
public class Solution {
  public ListNode insertNode(ListNode head, int target) {
    ListNode tar = new ListNode(target);
    ListNode cur = head;

    if (target < head.value) {
      tar.next = head;
      head = tar;

      return head;
    }

    while (cur.next != null) {
      if (cur.value <= target && target <= cur.next.value) {
        tar.next = cur.next;
        cur.next = tar;
        return head;
      }

      cur = cur.next;
    }

    cur.next = tar;

    return head;
  }
}

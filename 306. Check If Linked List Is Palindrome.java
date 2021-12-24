// Medium
// Given a linked list, 
// check whether it is a palindrome.

// Examples:
// Input:   1 -> 2 -> 3 -> 2 -> 1 -> null
// output: true.

// Input:   1 -> 2 -> 3 -> null  
// output: false.

// Requirements:
// Space complexity must be O(1)
  
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
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    ListNode mid = findMid(head);
    ListNode reverseNode = reverseLinkedList(mid.next);

    while (reverseNode != null) {
      if (head.value != reverseNode.value) {
        return false;
      }

      head = head.next;
      reverseNode = reverseNode.next;
    }

    return true;
  }

  private ListNode findMid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  private ListNode reverseLinkedList (ListNode head) {
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
// TC: O(n); SC: O(1)

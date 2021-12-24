// Medium
// Given a singly-linked list, 
// where each node contains an integer value, 
// sort it in ascending order. 
// The merge sort algorithm should be used to solve this problem.

// Examples
// null, is sorted to null
// 1 -> null, is sorted to 1 -> null
// 1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
// 4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
  
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
  public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode midNode = findMid(head);
    ListNode midHead = midNode.next;
    midNode.next = null;

    ListNode left = mergeSort(head);
    ListNode right = mergeSort(midHead);

    return merge(left, right);
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

  private ListNode merge(ListNode left, ListNode right) {
    ListNode dummyHead = new ListNode(0);
    ListNode cur = dummyHead;

    while (left != null && right != null) {
      if (left.value <= right.value) {
        cur.next = left;
        left = left.next;
      }
      else {
        cur.next = right;
        right = right.next;
      }

      cur = cur.next;
    }

    while (left != null) {
      cur.next = left;
      left = left.next;
      cur = cur.next;
    }

    while (right != null) {
      cur.next = right;
      right = right.next;
      cur = cur.next;
    }

    return dummyHead.next;
  }
}
// TC: O(nlogn + nlogn); SC: O(logn)

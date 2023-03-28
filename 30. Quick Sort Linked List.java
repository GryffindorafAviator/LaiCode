Hard
Given a singly-linked list, 
where each node contains an integer value, 
sort it in ascending order. 
The quick sort algorithm should be used to solve this problem.

Examples
null, is sorted to null
1 -> null, is sorted to 1 -> null
1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
  
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
  public ListNode quickSort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
        
    ListNode mid = getMid(head);
    ListNode left = quickSort(head);
    ListNode right = quickSort(mid);
    return merge(left, right);
  }

  ListNode merge(ListNode list1, ListNode list2) {
    ListNode dummyHead = new ListNode(0);
    ListNode tail = dummyHead;

    while (list1 != null && list2 != null) {
      if (list1.value < list2.value) {
        tail.next = list1;
        list1 = list1.next;
        tail = tail.next;
      } 
      else {
        tail.next = list2;
        list2 = list2.next;
        tail = tail.next;
      }
    }

    tail.next = (list1 != null) ? list1 : list2;

    return dummyHead.next;
  }

  ListNode getMid(ListNode head) {
    ListNode midPrev = null;

    while (head != null && head.next != null) {
      midPrev = (midPrev == null) ? head : midPrev.next;
      head = head.next.next;
    }

    ListNode mid = midPrev.next;
    midPrev.next = null;

    return mid;
  }
}

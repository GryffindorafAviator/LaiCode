// Medium
// You are given two linked lists representing two non-negative numbers. 
// The digits are stored in reverse order and each of their nodes contain a single digit. 
// Add the two numbers and return it as a linked list.  

// Example
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
  
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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
      return l1 == null ? l2 : l1;
    }

    int carry = 0;
    ListNode dummyHead = new ListNode(0);
    ListNode cur = dummyHead;

    while (l1 != null && l2 != null) {
      int temp = l1.value + l2.value + carry;
      ListNode tempNode = new ListNode(0);
      
      carry = temp / 10;
      tempNode.value = temp % 10;
      cur.next = tempNode;
      cur = cur.next;
      l1 = l1.next;
      l2 = l2.next;
    }

    while (l1 != null) {
      int temp = l1.value + carry;
      ListNode tempNode = new ListNode(0);

      carry = temp / 10;
      tempNode.value = temp % 10;
      cur.next = tempNode;
      cur = cur.next;
      l1 = l1.next;
    }

    while (l2 != null) {
      int temp = l2.value + carry;
      ListNode tempNode = new ListNode(0);

      carry = temp / 10;
      tempNode.value = temp % 10;
      cur.next = tempNode;
      cur = cur.next;
      l2 = l2.next;
    }

    if (carry != 0) {
      cur.next = new ListNode(carry);
    }

    return dummyHead.next;
  }
}
// TC: O(n); SC: O(1)

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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    int val = 0;

    while (l1 != null || l2 != null || val != 0) {
      if (l1 != null) {
        val += l1.value;
        l1 = l1.next;
      }

      if (l2 != null) {
        val += l2.value;
        l2 = l2.next;
      }

      cur.next = new ListNode(val % 10);
      val /= 10;
      cur = cur.next;
    }

    return dummy.next;
  }
}
// TC: O(n); SC: O(1)

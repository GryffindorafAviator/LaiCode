// Medium
// Merge K sorted lists into one big sorted list in ascending order.

// Assumptions
// ListOfLists is not null, 
// and none of the lists is null.
  
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
  static class MyComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode o1, ListNode o2) {
      if (o1.value == o2.value) {
        return 0;
      }

      return o1.value < o2.value ? -1 : 1;
    }
  }
  public ListNode merge(List<ListNode> listOfLists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new MyComparator());
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

    for (ListNode node : listOfLists) {
      if (node != null) {
        minHeap.offer(node);
      }
    }

    while (!minHeap.isEmpty()) {
      ListNode temp = minHeap.poll();
      cur.next = temp;

      if (temp.next != null) {
        minHeap.offer(temp.next);
      }

      cur = cur.next;
    }

    return dummy.next;
  }
}
// TC: O(nk*log(k)); SC: O(k)
// k = listOfLists.len; n = list.len

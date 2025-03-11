// Medium
// A Skip List is a special type of linked list, 
// where each of the nodes has a forward pointer to another node in the front and forward pointers are guaranteed to be in non-descending order.

// Make a deep copy of the original skip list.

// Solution

/**
 * class SkipListNode {
 *   public int value;
 *   public SkipListNode next;
 *   public SkipListNode forward;
 *   public SkipListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public SkipListNode copy(SkipListNode head) {
    if (head == null) {
      return head;
    }

    HashMap<SkipListNode, SkipListNode> map = new HashMap<>();
    SkipListNode newHead = new SkipListNode(head.value);
    map.put(head, newHead);
    SkipListNode curNew = newHead;
    SkipListNode cur = head.next;

    while (cur != null) {
      SkipListNode node = new SkipListNode(cur.value);
      map.put(cur, node);
      curNew.next = node;
      curNew = curNew.next;
      cur = cur.next;
    }

    curNew = newHead;
    cur = head;

    while (cur != null) {
      if (cur.forward != null) {
        SkipListNode frwd = map.get(cur.forward);
        curNew.forward = frwd;
      }
      cur = cur.next;
      curNew = curNew.next;
    }

    return newHead;
  }
}
// TC: O(n); SC: O(n)

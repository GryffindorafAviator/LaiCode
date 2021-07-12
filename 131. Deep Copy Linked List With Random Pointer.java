// Medium
// Each of the nodes in the linked list has another pointer pointing to a random node in the list or null. 
// Make a deep copy of the original list.
  
/**
 * class RandomListNode {
 *   public int value;
 *   public RandomListNode next;
 *   public RandomListNode random;
 *   public RandomListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    if (head == null) {
      return null;
    }

    RandomListNode newHead = new RandomListNode(head.value);
    RandomListNode cur = newHead;
    Map<RandomListNode, RandomListNode> lookup = new HashMap<>();
    lookup.put(head, newHead);

    while (head != null) {
      if (head.next != null) {
        if (!lookup.containsKey(head.next)) {
          lookup.put(head.next, new RandomListNode(head.next.value));
        }

        cur.next = lookup.get(head.next);
      }

      if (head.random != null) {
        if (!lookup.containsKey(head.random)) {
          lookup.put(head.random, new RandomListNode(head.random.value));
        }

        cur.random = lookup.get(head.random);
      }

      head = head.next;
      cur = cur.next;
    }
    
    return newHead;
  }
}

// TC: O(n), SC:O(1)

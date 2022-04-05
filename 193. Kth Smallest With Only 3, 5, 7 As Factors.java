// Medium
// Find the Kth smallest number s such that s = 3 ^ x * 5 ^ y * 7 ^ z, 
// x > 0 and y > 0 and z > 0, 
// x, y, z are all integers.

// Assumptions
// K >= 1
  
// Examples
// the smallest is 3 * 5 * 7 = 105
// the 2nd smallest is 3 ^ 2 * 5 * 7 = 315
// the 3rd smallest is 3 * 5 ^ 2 * 7 = 525
// the 5th smallest is 3 ^ 3 * 5 * 7 = 945
  
// Solution
public class Solution {
  public long kth(int k) {
    PriorityQueue<Long> minHeap = new PriorityQueue<>();
    Set<Long> visited = new HashSet<>();

    minHeap.offer(3 * 5 * 7L);
    visited.add(3 * 5 * 7L);

    while (k > 1) {
      long cur = minHeap.poll();

      --k;

      if (visited.add(3 * cur)) {
        minHeap.offer(3 * cur);
      }

      if (visited.add(5 * cur)) {
        minHeap.offer(5 * cur);
      }

      if (visited.add(7 * cur)) {
        minHeap.offer(7 * cur);
      }
    }
    
    return minHeap.peek();
  }
}
// TC: O(klogk); SC: O(k)

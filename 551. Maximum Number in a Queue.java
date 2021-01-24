// Easy
// Given a queue of integers, find the maximum number in it.

// Assumption: the queue is not null or empty.

// Example:
// Queue contains 5,8,3,2,7
// Answer: 8.

class Solution {
	public int maxInQueue(Queue<Integer> queue) {
    int max = queue.poll();

    while (!queue.isEmpty()) {
      int temp = queue.poll();

      if (max < temp) {
        max = temp;
      }
    }

    return max;
	}
}

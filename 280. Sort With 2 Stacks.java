// Medium
// Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).

// After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.

// Assumptions:

// The given stack is not null.
// There can be duplicated numbers in the give stack.
// Requirements:

// No additional memory, time complexity = O(n ^ 2).
 
// Solution
public class Solution {
  public void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<Integer>();
     
    while (!s1.isEmpty()) {
      int globalMin = s1.peekFirst();
      int cnt = 1;
      s2.offerFirst(s1.pollFirst());

      while (!s1.isEmpty()) {
        int temp = s1.peekFirst();

        if (temp < globalMin) {
          globalMin = temp;
          cnt = 1;
        }
        else if (temp == globalMin) {
          ++cnt;
        }

        s2.offerFirst(s1.pollFirst());
      }

      while (!s2.isEmpty() && s2.peekFirst() >= globalMin) {
        if (s2.peekFirst() > globalMin) {
          s1.offerFirst(s2.pollFirst());
        }
        else {
          s2.pollFirst();
        }
      }

      while (cnt != 0) {
        s2.offerFirst(globalMin);
        --cnt;
      }
    }

    while (!s2.isEmpty()) {
      s1.offerFirst(s2.pollFirst());
    }
  }
}

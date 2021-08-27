// Hard
// Given a non-negative integer array representing the heights of a list of adjacent bars. 
// Suppose each bar has a width of 1. 
// Find the largest rectangular area that can be formed in the histogram.

// Assumptions

// The given array is not null or empty
// Examples

// { 2, 1, 3, 3, 4 }, the largest rectangle area is 3 * 3 = 9(starting from index 2 and ending at index 4)

public class Solution {
  public int largest(int[] array) {
    int area = 0;
    Deque<Integer> stack = new LinkedList<>();

    for (int i = 0; i <= array.length; ++i) {
      int cur = i == array.length ? 0 : array[i];

      while (!stack.isEmpty() && cur <= array[stack.peekFirst()]) {
        int height = array[stack.pollFirst()];
        int left = stack.isEmpty() ? 0 : (stack.peekFirst() + 1);

        area = Math.max(area, height * (i - left));
      }

      stack.offerFirst(i);
    }

    return area;
  }
}

// TC: O(n), SC: O(n)

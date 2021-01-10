// Debug
// There are bugs in the given code, please fix them.

// Given an array, reverse all its elements.

// Example:
// array = [2, 3, 5, 7, 11]
// result: [11, 7, 5, 3, 2]

// Assumption: The array is not null or empty.

public class Solution {
  public void reverse(int[] array) {
    int start = 0;
    int end = array.length - 1;
    while (start < end) {
      int temp = array[start];
      array[start] = array[end];
      array[end] = temp;
      ++start;
      --end;
    }
  }
}

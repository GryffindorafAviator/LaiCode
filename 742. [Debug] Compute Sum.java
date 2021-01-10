// Debug
// Given an array, return the sum of all elements.

// Example:
// array = [7, 3, 2], return 12

// Note: if the array is null or empty, return -1.

public class Solution {
  public int sum(int[] array) {
    if (array == null || array.length == 0) {
      return -1;
    }
    int s = 0;
    for (int i = 0; i < array.length; i++) {
      s += array[i];
    }
    return s;
  }
}

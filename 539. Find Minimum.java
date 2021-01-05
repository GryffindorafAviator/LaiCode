// Easy
// Given an array, return its minimum value

// Example:
// array = [7, 3, 2], return 2

// Note: if the array is null or empty, return 0.

public class Solution {
  public int min(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }

    int min = array[0];

    for (int i = 1; i < array.length; ++i) {
      if (array[i] < min) {
        min = array[i];
      }
    } 

    return min;
  }
}

// Solution
public class Solution {
  public int min(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }

    int min = array[0];

    for (int i = 1; i < array.length; ++i) {
      min = array[i] < min ? array[i] : min;
    } 

    return min;
  }
}

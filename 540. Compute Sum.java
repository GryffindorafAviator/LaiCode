// Easy
// Given an array, return sum of all elements.

// Example:

// array = [7, 3, 2], return 12

// Note: if the array is null or empty, return 0.

public class Solution {
  public int sum(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }

    int sum = 0;

    for (int i = 0; i < array.length; ++i) {
      sum += array[i];
    }

    return sum;
  }
}

// Solution
public class Solution {
  public int sum(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }

    int sum = 0;

    for (int num : array) {
      sum += num;
    }

    return sum;
  }
}

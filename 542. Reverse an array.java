Easy
Given an array, reverse all its elements.

Example:
array = [2, 3, 5, 7, 11]
result: [11, 7, 5, 3, 2]

Assumption: The array is not null or empty.

public class Solution {
  public void reverse(int[] array) {
    for (int i = 0, j = array.length - 1; i < j; ++i, --j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }
}

// Solution
public class Solution {
  public void reverse(int[] array) {
    int i = 0, j = array.length - 1;

    while (i < j) {
      swap(array, i, j);
      ++i;
      --j;
    }
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

Easy
Given an array, and two indices i and j. Swap the element at position i and element at position j.

Example:
array = [7, 3, 2], i = 0, j = 2. 
Swap such that the array becomes [2, 3, 7]

Assumption: The array is not null or empty. i and j are both valid indices within the range of the array.

public class Solution {
  public void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

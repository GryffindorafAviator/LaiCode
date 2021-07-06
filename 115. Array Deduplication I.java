// Easy
// Given a sorted integer array, 
// remove duplicate elements. 
// For each group of elements with the same value keep only one of them. 
// Do this in-place, 
// using the left side of the original array and maintain the relative order of the elements of the array. 
// Return the array after deduplication.

// Assumptions

// The array is not null
// Examples

// {1, 2, 2, 3, 3, 3} → {1, 2, 3}

public class Solution {
  public int[] dedup(int[] array) {
    if (array == null || array.length < 2) {
      return array;
    }

    int slow = 1;
    int fast = 1;

    while (fast != array.length) {
      if (array[fast] != array[slow - 1]) {
        array[slow] = array[fast];
        ++slow;
      }

      ++fast;
    }

    return Arrays.copyOf(array, slow);
  }
}

// TC: O(n), SC: O(1).

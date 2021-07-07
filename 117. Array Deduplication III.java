// Medium
// Given a sorted integer array, 
// remove duplicate elements. 
// For each group of elements with the same value do not keep any of them. 
// Do this in-place, 
// using the left side of the original array and and maintain the relative order of the elements of the array. 
// Return the array after deduplication.

// Assumptions

// The given array is not null
  
// Examples

// {1, 2, 2, 3, 3, 3} → {1}

public class Solution {
  public int[] dedup(int[] array) {
    if (array == null || array.length < 2) {
      return array;
    }

    int fast = 1;
    int slow = 0;
    int end = 0;

    while (fast != array.length) {
      if (array[fast] != array[slow]) {
        if ((fast - slow) == 1) {
          array[end] = array[slow];
          ++end;
        }

        slow = fast;
        ++fast;
      }
      else {
        ++fast;
      }
    }

    if (slow == (array.length - 1)) {
      array[end] = array[slow];
      ++end;
    }

    return Arrays.copyOf(array, end);
  }
}

// TC: O(n), SC: O(1).

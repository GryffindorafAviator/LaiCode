// Medium
// Given a sorted integer array, 
// remove duplicate elements. 
// For each group of elements with the same value keep at most two of them. 
// Do this in-place, 
// using the left side of the original array and maintain the relative order of the elements of the array. 
// Return the array after deduplication.

// Assumptions

// The given array is not null
// Examples

// {1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}

public class Solution {
  public int[] dedup(int[] array) {
    if (array == null || array.length < 3) {
      return array;
    }

    int cnt = 1;
    int end = 1;

    for (int i = 1; i < array.length; ++i) {
      if (array[i] != array[end - 1]) {
        array[end] = array[i];
        ++end;
        cnt = 1;
      }
      else {
        if (cnt == 1) {
          ++end;
          ++cnt;
        }
        else {
          ++cnt;
        }
      }
    }

    return Arrays.copyOf(array, end);
  }
}

// TC: O(n), SC: O(1).

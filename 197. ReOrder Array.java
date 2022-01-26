// Hard
// Given an array of elements, 
// reorder it as follow:
// { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
// { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
// Try to do it in place.

// Assumptions
// The given array is not null
  
// Examples
// { 1, 2, 3, 4, 5, 6} → { 1, 4, 2, 5, 3, 6 }
// { 1, 2, 3, 4, 5, 6, 7, 8 } → { 1, 5, 2, 6, 3, 7, 4, 8 }
// { 1, 2, 3, 4, 5, 6, 7 } → { 1, 4, 2, 5, 3, 6, 7 }

// Solution
public class Solution {
  public int[] reorder(int[] array) {
    if (array == null) {
      return null;
    }

    if (array.length <= 2) {
      return array;
    }

    if (array.length % 2 == 0) {
      helper(array, 0, array.length - 1);
    }
    else {
      helper(array, 0, array.length - 2);
    }

    return array;
  }

  private void helper(int[] array, int left, int right) {
    int len = right - left + 1;

    if (len <= 2) {
      return;
    }

    int mid = left + len / 2;
    int lMid = left + len / 4;
    int rMid = left + len * 3 / 4;

    reverse(array, lMid, mid - 1);
    reverse(array, mid, rMid - 1);
    reverse(array, lMid, rMid - 1);

    helper(array, left, left + (lMid - left) * 2 - 1);
    helper(array, left + (lMid - left) * 2, right);
  }

  private void reverse(int[] array, int left, int right) {
    while (left < right) {
      int temp = array[left];

      array[left] = array[right];
      array[right] = temp;

      left++;
      right--;
    }
  }
}
// TC: O(nlgn); SC: O(lgn)

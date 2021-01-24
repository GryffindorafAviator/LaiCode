// Easy
// Given two sorted arrays, merge them into one sorted array.

// Assumption: the two arrays are not null or empty.

// Example:
// array1 = {3,7}
// array2 = {1,6,8,9}
// answer = {1,3,6,7,8,9}

public class Solution {
  public int[] merge(int[] one, int[] two) {
    int len_one = one.length;
    int len_two = two.length;
    int[] ans = new int[len_one + len_two];
    int i = 0, j = 0, k = 0;
    boolean one_flag = false, two_flag = false;

    while (i < len_one && j < len_two) {
      if (one[i] < two[j]) {
        ans[k] = one[i];
        ++i;
        ++k;
      }
      else {
        ans[k] = two[j];
        ++j;
        ++k;
      }

      if (i == len_one) {
        one_flag = true;
      }

      if (j == len_two) {
        two_flag = true;
      }
    }

    if (one_flag) {
      for (; j < len_two; ++j) {
        ans[k] = two[j];
        ++k;
      }
    }

    if (two_flag) {
      for (; i < len_one; ++i) {
        ans[k] = one[i];
        ++k;
      }
    }

    return ans;
  }
}

// Solution
public class Solution {
  public int[] merge(int[] one, int[] two) {
    int len_one = one.length;
    int len_two = two.length;
    int[] ans = new int[len_one + len_two];
    int i = 0, j = 0, k = 0;

    while (i < len_one && j < len_two) {
      if (one[i] < two[j]) {
        ans[k] = one[i];
        ++i;
      }
      else {
        ans[k] = two[j];
        ++j;
      }

      ++k;
    }

    while (i < len_one) {
      ans[k] = one[i];
      ++i;
      ++k;
    }

    while (j < len_two) {
      ans[k] = two[j];
      ++j;
      ++k;
    }

    return ans;
  }
}

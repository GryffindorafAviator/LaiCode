// Medium
// Given an array of integers, sort the elements in the array in ascending order. 
// The merge sort algorithm should be used to solve this problem.

// Examples
// {1} is sorted to {1}
// {1, 2, 3} is sorted to {1, 2, 3}
// {3, 2, 1} is sorted to {1, 2, 3}
// {4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}

// Corner Cases
// What if the given array is null? In this case, we do not need to do anything.
// What if the given array is of length zero? In this case, we do not need to do anything.

// Solution
public class Solution {
  public int[] mergeSort(int[] array) {
    if (array == null || array.length <= 1) {
      return array;
    }

    return divide(array, 0, array.length - 1);
  }

  private int[] divide(int[] array, int left, int right) {
    if (left == right) {
      return new int[] {array[left]};
    }

    int mid = left + (right - left) / 2;

    int[] leftArray = divide(array, left, mid);
    int[] rightArray = divide(array, mid + 1, right);
    int[] result = merge(leftArray, rightArray);

    return result;
  }

  private int[] merge(int[] leftArray, int[] rightArray) {
    int leftLen = leftArray.length;
    int rightLen = rightArray.length;
    int[] ans = new int[leftLen + rightLen];
    int i = 0, j = 0, k = 0;

    while (i < leftLen && j < rightLen) {
      if (leftArray[i] < rightArray[j]) {
        ans[k] = leftArray[i];
        ++i;
      }
      else {
        ans[k] = rightArray[j];
        ++j;
      }

      ++k;
    }

    while (i < leftLen) {
      ans[k] = leftArray[i];
      ++i;
      ++k;
    }

    while (j < rightLen) {
      ans[k] = rightArray[j];
      ++j;
      ++k;
    }

    return ans;
  }
}

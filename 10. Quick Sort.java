// Medium
// Given an array of integers, sort the elements in the array in ascending order. 
// The quick sort algorithm should be used to solve this problem.

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
  public int[] quickSort(int[] array) {
    if (array == null || array.length <= 1) {
      return array;
    }

    helper(array, 0, array.length - 1);

    return array;
  }

  private Random rand = new Random();

  private void helper(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }

    int pivot = left + rand.nextInt(right - left + 1);

    swap(array, pivot, right);

    int i = left;
    int j = right - 1;

    while (i <= j) {
      if (array[i] > array[right]) {
        swap(array, i, j);
        --j;
      }
      else {
        ++i;
      }
    }

    swap(array, i, right);

    helper(array, left, i - 1);
    helper(array, i + 1, right);
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

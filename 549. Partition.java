// Easy
// Given an array, and a pivotIndex. 
// Rearrange the array so that the numbers smaller than array[pivotIndex] are on the left side of array[pivotIndex],
// and numbers larger than array[pivotIndex] are on the right side of array[pivotIndex].

// Assumption:
// The array is not null or empty. pivotIndex is within the boundary of the array.

// Example:
// array = {9,4,6,2,0,1,7}
// pivotIndex = 2
// Result: {1, 4, 0, 2, 6, 9, 7} 

class Solution {
	public void partition(int[] array, int pivotIndex) {
    if (array == null || array.length <= 1) {
      return;
    }

    swap(array, pivotIndex, array.length - 1);

    int i = 0;
    int j = array.length - 2;

    while (i <= j) {
      if (array[i] > array[array.length - 1]) {
        swap(array, i, j);
        --j;
      }
      else {
        ++i;
      }
    }

    swap(array, i, array.length - 1);
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

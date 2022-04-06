// Medium
// Given an array A of non-negative integers, 
// you are initially positioned at index 0 of the array. 
// A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). 
// Determine the minimum number of jumps you need to reach the end of array. 
// If you can not reach the end of the array, 
// return -1.

// Assumptions
// The given array is not null and has length of at least 1.

// Examples
// {3, 3, 1, 0, 4}, 
// the minimum jumps needed is 2 (jump to index 1 then to the end of array)

// {2, 1, 1, 0, 2}, 
// you are not able to reach the end of array, return -1 in this case.

// Solution
public class Solution {
  public int minJump(int[] array) {
    int[] steps = new int[array.length];
    steps[array.length - 1] = 0;
    int lastTrue = array.length - 1;

    for (int i = array.length - 2; i >= 0; --i) {
      if (array[i] >= lastTrue - i) {
        lastTrue = i;
        int min = Integer.MAX_VALUE;
        
        for (int j = i + 1; j < Math.min((i + array[i] + 1), array.length); ++j) {
          if (steps[j] != -1) {
            int temp = steps[j] + 1;

            if (temp < min) {
              min = temp;
            }
          }
        }

        steps[i] = min;
      }
      else {
        steps[i] = -1;
      }
    }

    return steps[0];
  }
}

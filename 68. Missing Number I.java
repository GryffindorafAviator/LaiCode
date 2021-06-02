Medium
Given an integer array of size N - 1, containing all the numbers from 1 to N except one, find the missing number.

Assumptions

The given array is not null, and N >= 1
Examples

A = {2, 1, 4}, the missing number is 3
A = {1, 2, 3}, the missing number is 4
A = {}, the missing number is 1
  
public class Solution {
  public int missing(int[] array) {
    int N = array.length + 1;

    if (N - 1 == 0) {
      return 1;
    }

    int rslt = 0;
    
    for (int i = 0; i < N - 1; ++i) {
      rslt += i + 1 - array[i];
    }

    return rslt + N;
  }
}

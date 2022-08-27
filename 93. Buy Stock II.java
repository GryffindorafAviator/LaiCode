// Easy
// Given an array of positive integers representing a stock’s price on each day. 
// On each day you can only make one operation: 
// either buy or sell one unit of stock, 
// you can make as many transactions you want, 
// but at any time you can only hold at most one unit of stock. 
// Determine the maximum profit you can make.

// Assumptions
// The give array is not null and is length of at least 2
  
// Examples
// {2, 3, 2, 1, 4, 5}, 
// the maximum profit you can make is (3 - 2) + (5 - 1) = 5

// Solution
public class Solution {
  public int maxProfit(int[] array) {
    int ans = 0;
    int min = array[0];
    boolean rise = array[1] > array[0] ? true : false;

    for (int i = 1; i < array.length; i++) {
      if (rise && array[i] < array[i - 1]) {
        ans += array[i - 1] - min;
        min = array[i];
        rise = false;
      }
      else if (!rise && array[i] > array[i - 1]) {
        min = array[i - 1];
        rise = true;
      }
    }

    if (array[array.length - 1] > min) {
      ans += array[array.length - 1] - min;
    }
    
    return ans;
  }
}
// TC: O(n); SC: O(1)

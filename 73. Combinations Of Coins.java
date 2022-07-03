// Medium
// Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), 
// get all the possible ways to pay a target number of cents.

// Arguments
// coins - an array of positive integers representing the different denominations of coins, 
// there are no duplicate numbers and the numbers are sorted by descending order, 
// eg. {25, 10, 5, 2, 1}
// target - a non-negative integer representing the target number of cents, 
// eg. 99

// Assumptions
// coins is not null and is not empty, 
// all the numbers in coins are positive.
// target >= 0
// You have infinite number of coins for each of the denominations, 
// you can pick any number of the coins.

// Return
// a list of ways of combinations of coins to sum up to be target.
// each way of combinations is represented by list of integer, 
// the number at each index means the number of coins used for the denomination at corresponding index.

// Examples
// coins = {2, 1}, target = 4, the return should be

// [
//   [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)
//   [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)
//   [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)
// ]

// Solution 1
public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> combin = new ArrayList<>();

    helper(target, coins, 0, combin, result);

    return result;
  }

  private void helper(int target, int[] coins, int index, List<Integer> combin, List<List<Integer>> result) {
    if (index == coins.length - 1) {
      if (target % coins[index] == 0) {
        combin.add(target / coins[index]);
        result.add(new ArrayList<>(combin));
        combin.remove(combin.size() - 1);
      }

      return;
    }

    for (int i = 0; i < target / coins[index] + 1; ++i) {
      combin.add(i);
      helper(target - coins[index] * i, coins, index + 1, combin, result);
      combin.remove(combin.size() - 1);
    }
  }
} 
// TC: O(max(target / coins[i])^n); SC: O(n)

// Solution 2
public class Solution {
  public List<List<Integer>> combinations(int target, int[] coins) {
    if (coins == null || coins.length == 0) {
      return null;
    }

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    dfs(target, coins, 0, 0, temp, ans);

    return ans;
  }

  private void dfs(int target, int[] coins, int sum, int idx, List<Integer> temp, List<List<Integer>> ans) {
    if (idx == coins.length) {
      if (sum == target) {
        List<Integer> addAns = new ArrayList<>(temp);
        ans.add(addAns);
      }

      return;
    }

    for (int i = 0; i < target / coins[idx] + 1; i++) {
      sum += i * coins[idx];
      temp.add(i);

      dfs(target, coins, sum, idx + 1, temp, ans);

      sum -= i * coins[idx];
      temp.remove(temp.size() - 1);
    }
  }
}
// TC: O(max(target / coins[i])^n); SC: O(n)

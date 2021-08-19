// Medium
// Given an integer number, 
// return all possible combinations of the factors that can multiply to the target number.

// Example

// Give A = 24

// since 24 = 2 x 2 x 2 x 3

//               = 2 x 2 x 6

//               = 2 x 3 x 4

//               = 2 x 12

//               = 3 x 8

//               = 4 x 6

// your solution should return

// { { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }

// note: duplicate combination is not allowed.

public class Solution {
  public List<List<Integer>> combinations(int target) {
    List<List<Integer>> ans = new ArrayList<>();

    if (target < 2) {
      return ans;
    }

    List<Integer> factors = factors(target);
    List<Integer> cur = new ArrayList<>();

    helper(target, factors, 0, cur, ans);

    return ans;
  }

  private void helper(int target, List<Integer> factors, int index, List<Integer> cur, List<List<Integer>> ans) {
    if (index == factors.size()) {
      if (target == 1) {
        ans.add(new ArrayList<>(cur));
      }

      return;
    }

    helper(target, factors, index + 1, cur, ans);

    int size = cur.size();

    while ((target % factors.get(index) == 0)) {
      cur.add(factors.get(index));
      target /= factors.get(index);

      helper(target, factors, index + 1, cur, ans);
    }

    cur.subList(size, cur.size()).clear();
  }

  private List<Integer> factors(int target) {
    List<Integer> li = new ArrayList<>();

    for (int i = 2; i <= Math.sqrt(target); ++i) {
      if ((target % i) == 0) {
        li.add(i);

        if (i != target / i) {
          li.add(target / i);
        }
      }
    }

    Collections.sort(li);
    Collections.reverse(li);
  
    return li;
  }
}

// Easy
// Problem: Give an array list of integer, calculate the sum of squares of all its elements.

// Note: return 0 if the list is null or empty.

// Example:
// list = {1,2,3} → returns 14 (14=1*1+2*2+3*3)

public class Solution {
  public int sumOfSquare(List<Integer> list) {
    int ans = 0;

    for (int i = 0; i < list.size(); ++i) {
      ans += list.get(i) * list.get(i);
    }

    return ans;
  }
}

public class Solution {
  public int sumOfSquare(List<Integer> list) {
    int ans = 0;

    for (int num : list) {
      ans += num * num;
    }

    return ans;
  }
}

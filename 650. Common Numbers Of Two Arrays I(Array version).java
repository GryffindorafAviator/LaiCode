// Easy
// Find all numbers that appear in both of the two unsorted arrays, 
// return the common numbers in increasing order.

// Assumptions

// Both arrays are not null.
// There are no duplicate numbers in each of the two arrays respectively.
// Exmaples

// A = {1, 2, 3}, B = {3, 1, 4}, return [1, 3]
// A = {}, B = {3, 1, 4}, return []

public class Solution {
  public List<Integer> common(int[] a, int[] b) {
    List<Integer> ans = new ArrayList<>();

    if (a.length == 0 || b.length == 0) {
      return ans;
    }

    Set<Integer> set = new HashSet<>();
    int cnt = 0;

    if (a.length <= b.length) {
      putInSet(set, a);
      findHelper(b, set, ans, cnt);
    }
    else {
      putInSet(set, b);
      findHelper(a, set, ans, cnt);
    }

    ans.sort(Comparator.naturalOrder());

    return ans;
  }

  private void findHelper(int[] a, Set<Integer> set, List<Integer> ans, int cnt) {
    for (int num : a) {
      if (cnt == set.size()) {
        break;
      }

      if (set.contains(num)) {
        ans.add(num);
        ++cnt;
      }
    }
  }

  private void putInSet(Set<Integer> set, int[] a) {
    for (int num : a) {
      set.add(num);
    }
  }
}

// TC: O(n), SC: O(n)

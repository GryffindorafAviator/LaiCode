// Easy
// Find all numbers that appear in both of two unsorted arrays.

// Assumptions

// Both of the two arrays are not null.
// In any of the two arrays, there could be duplicate numbers.
// Examples

// A = {1, 2, 3, 2}, B = {3, 4, 2, 2, 2}, return [2, 2, 3] (there are both two 2s in A and B)

public class Solution {
  public List<Integer> common(int[] A, int[] B) {
    List<Integer> ans = new ArrayList<>();

    if (A.length == 0 || B.length == 0) {
      return ans;
    }

    HashMap<Integer, Integer> hm = new HashMap<>();
    int cnt = 0;

    if (A.length <= B.length) {
      putInHM(A, hm);
      findHelper(B, hm, cnt, A.length, ans);
    }
    else {
      putInHM(B, hm);
      findHelper(A, hm, cnt, B.length, ans);
    }

    ans.sort(Comparator.naturalOrder());

    return ans;
  }

  private void findHelper(int[] a, HashMap<Integer, Integer> hm, int cnt, int len, List<Integer> ans) {
    for (int num : a) {
      if (cnt == len) {
        break;
      }

      if (hm.containsKey(num)) {
        ans.add(num);
        ++cnt;
        hm.put(num, hm.get(num) - 1);

        if (hm.get(num) == 0) {
          hm.remove(num);
        }
      }
    }
  }

  private void putInHM(int[] a, HashMap<Integer, Integer> hm) {
    for (int num : a) {
      hm.put(num, hm.getOrDefault(num, 0) + 1);
    }
  }
}

// TC: O(n), SC: O(n)

// Medium
// Determine if there exists a set of four elements in a given array that sum to the given target number.

// Assumptions
// The given array is not null and has length of at least 4
  
// Examples
// A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 9)
// A = {1, 2, 2, 3, 4}, target = 12, return false
  
// Solution 1
public class Solution {
  public boolean exist(int[] array, int target) {
    if (array == null || array.length < 4) {
      return false;
    }

    int len = array.length;

    Arrays.sort(array);

    for (int i = 0; i < len - 3; i++) {
      for (int j = i + 1; j < len - 2; j++) {
        int left = j + 1;
        int right = len - 1;

        while (left < right) {
          int temp = array[i] + array[j] + array[left] + array[right];

          if (temp == target) {
            return true;
          }
          else if (temp < target) {
            left++;
          }
          else {
            right--;
          }
        }
      }
    }

    return false;
  }
}
// TC: O(n^3); SC: O(1)

// Solution 2
public class Solution {
  static class Element implements Comparable<Element> {
    int left;
    int right;
    int sum;

    Element(int left, int right, int sum) {
      this.left = left;
      this.right = right;
      this.sum = sum;
    }

    @Override
    public int compareTo(Element another) {
      if (this.sum != another.sum) {
        return this.sum < another.sum ? -1 : 1;
      }
      else if (this.right != another.right) {
        return this.right < another.right ? -1 : 1;
      }
      else if (this.left != another.left) {
        return this.left < another.left ? -1 : 1;
      }

      return 0;
    }
  }

  public boolean exist(int[] array, int target) {
    if (array == null || array.length < 4) {
      return false;
    }

    Arrays.sort(array);

    Element[] pairSum = getPairSum(array);
    Arrays.sort(pairSum); // O(n^2 * 2 * logn)

    int left = 0;
    int right = pairSum.length - 1;

    while (left < right) {
      int tempSum = pairSum[left].sum + pairSum[right].sum;

      if (tempSum == target && pairSum[left].right < pairSum[right].left) {
        return true;
      }
      else if (tempSum < target) {
        left++;
      }
      else {
        right--;
      }
    }

    return false;
  }

  private Element[] getPairSum(int[] array) {
    int len = array.length;

    Element[] pairSum = new Element[len * (len - 1) / 2];
    int cur = 0;

    for (int j = 1; j < len; j++) {
      for (int i = 0; i < j; i++) {
        pairSum[cur] = new Element(i, j, array[i] + array[j]);
        cur++;
      }
    }

    return pairSum;
  }
}
// TC: O(n^2 * logn); SC: O(n^2)

// Solution 3
public class Solution {
  static class Pair {
    int left;
    int right;

    Pair(int left, int right) {
      this.left = left;
      this.right = right;
    }
  }

  public boolean exist(int[] array, int target) {
    if (array == null || array.length < 4) {
      return false;
    }

    Map<Integer, Pair> hm = new HashMap<>();

    for (int j = 1; j < array.length; j++) {
      for (int i = 0; i < j; i++) {
        int tempSum = array[i] + array[j];

        if (hm.containsKey(target - tempSum) && hm.get(target - tempSum).right < i) {
          return true;
        }

        if (!hm.containsKey(tempSum)) {
          hm.put(tempSum, new Pair(i, j));
        }
      }
    }

    return false;
  }
}
// TC: O(n^2); SC: O(n^2)

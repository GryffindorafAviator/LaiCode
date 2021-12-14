// Medium
// Use the least number of comparisons to get the largest and 2nd largest number in the given integer array. 
// Return the largest number and 2nd largest number.

// Assumptions
// The given array is not null and has length of at least 2
  
// Examples
// {2, 1, 5, 4, 3}, 
// the largest number is 5 and 2nd largest number is 4.
  
// Solution
public class Solution {
  static class Element {
    int value;
    List<Integer> comparedValues;

    Element(int value) {
      this.value = value;
      this.comparedValues = new ArrayList<>();
    }
  }

  public int[] largestAndSecond(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }

    int n = array.length;

    Element[] eleArr = convert(array, n);

    while (n > 1) {
      compareAndSwap(eleArr, n);
      n = (n + 1) / 2;
    }

    int max = eleArr[0].value;
    int secondMax = largest(eleArr[0].comparedValues);
    int[] ans = new int[]{max, secondMax};

    return ans;
  }

  private Element[] convert(int[] array, int n) {
    Element[] eleArr = new Element[n];

    for (int i = 0; i < n; i++) {
      eleArr[i] = new Element(array[i]);
    }

    return eleArr;
  }

  private void compareAndSwap(Element[] eleArr, int n) {
    for (int i = 0; i < n / 2; i++) {
      if (eleArr[i].value < eleArr[n - 1 - i].value) {
        swap(eleArr, i, n - 1 - i);
      }

      eleArr[i].comparedValues.add(eleArr[n - 1 - i].value);
    }
  }

  private void swap(Element[] eleArr, int i, int j) {
    Element temp = eleArr[i];
    eleArr[i] = eleArr[j];
    eleArr[j] = temp;
  }

  private int largest(List<Integer> list) {
    int max = list.get(0);

    for (int num : list) {
      max = Math.max(max, num);
    }

    return max;
  }
}

// TC: O(n - 1 + longn - 1); SC: O(n)

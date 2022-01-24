// Medium
// Given one stack with integers, 
// sort it with two additional stacks (total 3 stacks). 

// After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.

// Assumptions:
// The given stack is not null.
// The time complexity should be O(n log n).

// Solution
public class Solution {
  public void sort(LinkedList<Integer> s1) {
    if (s1 == null || s1.size() == 0) {
      return;
    }

    LinkedList<Integer> s2 = new LinkedList<Integer>();
    LinkedList<Integer> s3 = new LinkedList<Integer>();

    helper(s1, s2, s3, s1.size());
  }

  private void helper(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int s1Len) {
    if (s1Len <= 1) {
      return;
    }

    int mid1 = s1Len / 2;
    int mid2 = s1Len - mid1;

    for (int i = 0; i < mid1; i++) {
      s2.offerFirst(s1.pollFirst());
    }

    helper(s2, s1, s3, mid1);
    helper(s1, s2, s3, mid2);

    int i = 0;
    int j = 0;

    while (i < mid1 && j < mid2) {
      if (s2.peekFirst() < s1.peekFirst()) {
        s3.offerFirst(s2.pollFirst());
        i++;
      }
      else {
        s3.offerFirst(s1.pollFirst());
        j++;
      }
    }

    while (i < mid1) {
      s3.offerFirst(s2.pollFirst());
      i++;
    }

    while (j < mid2) {
      s3.offerFirst(s1.pollFirst());
      j++;
    }

    for (int idx = 0; idx < s1Len; idx++) {
      s1.offerFirst(s3.pollFirst());
    }
  }
}
// TC: O(nlogn); SC: O(logn)

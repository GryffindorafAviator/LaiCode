// Medium
// Given two sorted arrays A and B, of sizes m and n respectively. 
// Define s = a + b, where a is one element from A and b is one element from B. 
// Find the Kth smallest s out of all possible s'.

// Assumptions

// A is not null and A is not of zero length, so as B
// K > 0 and K <= m * n
// Examples

// A = {1, 3, 5}, B = {4, 8}

// 1st smallest s is 1 + 4 = 5
// 2nd smallest s is 3 + 4 = 7
// 3rd, 4th smallest s are 9 (1 + 8, 4 + 5) 
// 5th smallest s is 3 + 8 = 11

public class Solution {
  public int kthSum(int[] A, int[] B, int k) {
    if (k == 1) {
      return A[0] + B[0];
    }

    int lenA = A.length;
    int lenB = B.length;

    if (k == lenA * lenB) {
      return A[lenA - 1] + B[lenB - 1];
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
      @Override
      public int compare(int[] a, int[] b) {
        return Integer.compare(A[a[0]] + B[a[1]], A[b[0]] + B[b[1]]);
      }
    });
    Set<Integer> expanded = new HashSet<>();
    int[][] dirs = new int[][]{{0, 1}, {1, 0}};

    pq.offer(new int[]{0, 0});
    expanded.add(0);

    while(!pq.isEmpty()) {
      int[] cur = pq.poll();
      --k;

      if (k == 0) {
        return A[cur[0]] + B[cur[1]];
      }

      for (int[] dir : dirs) {
        int nextI = cur[0] + dir[0];
        int nextJ = cur[1] + dir[1];

        if (nextI < lenA && nextJ < lenB && expanded.add(nextI + nextJ * 10)) {
          pq.offer(new int[]{nextI, nextJ});
        }
      }  
    }

    return -1;
  }
}

// TC: O(k * logk + k); SC: O(k)

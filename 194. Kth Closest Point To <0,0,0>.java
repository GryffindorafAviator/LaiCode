// Medium
// Given three arrays sorted in ascending order. 
// Pull one number from each array to form a coordinate <x,y,z> in a 3D space. 
// Find the coordinates of the points that is k-th closest to <0,0,0>.

// We are using euclidean distance here.

// Assumptions
// The three given arrays are not null or empty, 
// containing only non-negative numbers
// K >= 1 and K <= a.length * b.length * c.length
// Return

// a size 3 integer list, 
// the first element should be from the first array, 
// the second element should be from the second array and the third should be from the third array

// Examples
// A = {1, 3, 5}, B = {2, 4}, C = {3, 6}

// The closest is <1, 2, 3>, distance is sqrt(1 + 4 + 9)

// The 2nd closest is <3, 2, 3>, distance is sqrt(9 + 4 + 9)
  
// Solution
public class Solution {
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> o1, List<Integer> o2) {
        long dist1 = dist(o1, a, b, c);
        long dist2 = dist(o2, a, b, c);

        if (dist1 == dist2) {
          return 0;
        }

        return dist1 < dist2 ? -1 : 1;
      }
    });

    Set<List<Integer>> visited = new HashSet<>();
    List<Integer> ans = Arrays.asList(0, 0, 0);

    minHeap.offer(ans);
    visited.add(ans);

    while (k > 1) {
      ans = minHeap.poll();
      --k;

      List<Integer> temp = Arrays.asList(ans.get(0) + 1, ans.get(1), ans.get(2));

      if (temp.get(0) < a.length && visited.add(temp)) {
        minHeap.offer(temp);
      }

      temp = Arrays.asList(ans.get(0), ans.get(1) + 1, ans.get(2));

      if (temp.get(1) < b.length && visited.add(temp)) {
        minHeap.offer(temp);
      }

      temp = Arrays.asList(ans.get(0), ans.get(1), ans.get(2) + 1);

      if (temp.get(2) < c.length && visited.add(temp)) {
        minHeap.offer(temp);
      }
    }

    ans.set(0, a[minHeap.peek().get(0)]);
    ans.set(1, b[minHeap.peek().get(1)]);
    ans.set(2, c[minHeap.peek().get(2)]);
    
    return ans;
  }

  private long dist(List<Integer> point, int[] a, int[] b, int[] c) {
    long dis = 0;

    dis += Math.pow(a[point.get(0)], 2);
    dis += Math.pow(b[point.get(1)], 2);
    dis += Math.pow(c[point.get(2)], 2);

    return dis;
  }
}

// TC: O(klogk); SC: O(k)

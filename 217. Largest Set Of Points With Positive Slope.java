// Medium
// Given an array of 2D coordinates of points (all the coordinates are integers), 
// find the largest number of points that can form a set such that any pair of points in the set can form a line with positive slope. 
// Return the size of such a maximal set.

// Assumptions
// The given array is not null
// Note: 
// if there does not even exist 2 points can form a line with positive slope, should return 0.
  
// Examples
// <0, 0>, <1, 1>, <2, 3>, <3, 3>, 
// the maximum set of points are {<0, 0>, <1, 1>, <2, 3>}, 
// the size is 3.
  
// Solution
/*
* class Point {
*   public int x;
*   public int y;
*   public Point(int x, int y) {
*     this.x = x;
*     this.y = y;
*   }
* }
*/
public class Solution {
  public int largest(Point[] points) {
    if (points == null || points.length < 2) {
      return 0;
    }

    Arrays.sort(points, new MyComparator());

    int ans = 0;
    int[] longest = new int[points.length];

    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < i; j++) {
        if (points[j].y < points[i].y) {
          longest[i] = Math.max(longest[i], longest[j]);
        }
      }

      longest[i]++;
      ans = Math.max(ans, longest[i]);
    }

    return ans == 1 ? 0 : ans;
  }

  static class MyComparator implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
      return p1.x != p2.x ? p1.x - p2.x : p2.y - p1.y;
    }
  }
}
// TC: O(n^2); SC: O(n)

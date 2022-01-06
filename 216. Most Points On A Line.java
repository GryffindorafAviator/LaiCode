// Medium
// Given an array of 2D coordinates of points (all the coordinates are integers), 
// find the largest number of points that can be crossed by a single line in 2D space.

// Assumptions
// The given array is not null and it has at least 2 points

// Examples
// <0, 0>, <1, 1>, <2, 3>, <3, 3>, 
// the maximum number of points on a line is 3(<0, 0>, <1, 1>, <3, 3> are on the same line)
  
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
  public int most(Point[] points) {
    if (points.length < 3) {
      return points.length;
    }

    int max = 0;
  
    for (int i = 0; i < points.length; i++) {
      int same = 1;
      int sameX = 0;
      int temp = 0;
      Map<Double, Integer> hm = new HashMap<>();

      for (int j = 0; j < points.length; j++) {
        if (i == j) {
          continue;
        }
        
        if (points[i].x == points[j].x && points[i].y == points[j].y) {
          same++;
        }
        else if (points[i].x == points[j].x) {
          sameX++;
        }
        else {
          double slope = (points[i].y - points[j].y + 0.0) / (points[i].x - points[j].x);
          
          hm.put(slope, hm.getOrDefault(slope, 0) + 1);

          temp = Math.max(hm.get(slope), temp);
        }
      }

      temp = Math.max(temp, sameX) + same;
      max = Math.max(temp, max);
    }

    return max;
  }
}
// TC: O(n^2); SC: O(1)

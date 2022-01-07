// Medium
// Merge K sorted array into one big sorted array in ascending order.

// Assumptions
// The input arrayOfArrays is not null, 
// none of the arrays is null either.
  
// Solution
public class Solution {
  static class Entry {
    int row;
    int col;
    int value;

    Entry(int row, int col, int value) {
      this.row = row;
      this.col = col;
      this.value = value;
    }
  }

  static class MyComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry e1, Entry e2) {
      if (e1.value == e2.value) {
        return 0;
      }

      return e1.value < e2.value ? -1 : 1;
    }
  }

  public int[] merge(int[][] arrayOfArrays) {
    PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(new MyComparator());
    int len = 0;

    for (int i = 0; i < arrayOfArrays.length; i++) {
      len += arrayOfArrays[i].length;

      if (arrayOfArrays[i].length != 0) {
        minHeap.offer(new Entry(i, 0, arrayOfArrays[i][0]));
      }
    }

    int[] ans = new int[len];
    int cur = 0;

    while (!minHeap.isEmpty()) {
      Entry e = minHeap.poll();
      ans[cur] = e.value;
      cur++;

      if (e.col + 1 < arrayOfArrays[e.row].length) {
        e.col++;
        e.value = arrayOfArrays[e.row][e.col];
        minHeap.offer(e);
      }
    }

    return ans;
  }
}
// TC: O(row.len * col.len * log(col.len); SC: O(log(col.len))

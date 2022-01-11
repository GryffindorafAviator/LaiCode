// Medium
// There are a total of n courses you have to take, 
// labeled from 0 to n - 1.
// Some courses may have prerequisites, 
// for example to take course 0 you have to first take course 1, 
// which is expressed as a pair: [0,1]

// Given the total number of courses and a list of prerequisite pairs, 
// return the ordering of courses you should take to finish all courses.

// There may be multiple correct orders, 
// you just need to return one of them. 
// If it is impossible to finish all courses, 
// return an empty array.

// For example:
// 2, [[1,0]]
// There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. 
// So the correct course order is [0,1]

// 4, [[1,0],[2,0],[3,1],[3,2]]
// There are a total of 4 courses to take. 
// To take course 3 you should have finished both courses 1 and 2. 
// Both courses 1 and 2 should be taken after you finished course 0. 
// So one correct course order is [0,1,2,3]. 
// Another correct ordering is[0,2,1,3].

// Note:
// The input prerequisites is a graph represented by a list of edges, 
// not adjacency matrices. 
// Read more about how a graph is represented.
// You may assume that there are no duplicate edges in the input prerequisites.
  
// Solution
public class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] pair : prerequisites) {
      int crs = pair[0];
      int pre = pair[1];

      graph.get(pre).add(crs);
    }

    return topologicalSort(numCourses, graph);
  }

  private int[] topologicalSort(int numCourses, List<List<Integer>> graph) {
    int[] topologicalOrder = new int[numCourses];
    int[] incomingEdges = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
      for (int crs : graph.get(i)) {
        incomingEdges[crs]++;
      }
    }

    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < numCourses; i++) {
      if (incomingEdges[i] == 0) {
        queue.offer(i);
      }
    }

    int cnt = 0;

    while (!queue.isEmpty()) {
      int pre = queue.poll();

      topologicalOrder[cnt] = pre;
      cnt++;

      for (int crs : graph.get(pre)) {
        incomingEdges[crs]--;

        if (incomingEdges[crs] == 0) {
          queue.offer(crs);
        }
      }
    }

    return cnt == numCourses ? topologicalOrder : new int[] {};
  }
}

// TC: O(V + E); SC: O(V + E)

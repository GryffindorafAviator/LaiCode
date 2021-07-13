// Medium
// Make a deep copy of an undirected graph, 
// there could be cycles in the original graph.

// Assumptions

// The given graph is not null

/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    if (graph == null) {
      return graph;
    }

    Map<GraphNode, GraphNode> lookup = new HashMap<>();

    for (GraphNode gn : graph) {
      if (!lookup.containsKey(gn)) {
        lookup.put(gn, new GraphNode(gn.key));
      }

      dfs(gn, lookup);
    }

    return new ArrayList<GraphNode>(lookup.values());
  }

  private void dfs(GraphNode seed, Map<GraphNode, GraphNode> lookup) {
    for (GraphNode gn : seed.neighbors) {
      if (!lookup.containsKey(gn)) {
        lookup.put(gn, new GraphNode(gn.key));
        dfs(gn, lookup);
      }

      GraphNode copy = lookup.get(seed);
      copy.neighbors.add(lookup.get(gn));
    }
  }
}

// TC: O(n), SC:O(1)

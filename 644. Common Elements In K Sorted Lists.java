// Medium
// Find all common elements in K sorted lists.

// Assumptions
// The input and its elements are not null, 
// and support fast random access.
// There could be duplicate elements in each of the lists.

// Examples
// Input = {{1, 2, 2, 3}, {2, 2, 3, 5}, {2, 2, 4}}, 
// the common elements are {2, 2}.

// Solution
public class Solution {
  public List<Integer> commonElementsInKSortedArrays(List<List<Integer>> input) {
    List<Integer> ans = new ArrayList<>();

    if (input == null || input.size() == 0) {
      return ans;
    }

    ans = input.get(0);

    int i = 0;

    while (i < input.size()) {
      ans = helper(ans, input.get(i));
      i++;
    }

    return ans;
  }

  private List<Integer> helper(List<Integer> a, List<Integer> b) {
    List<Integer> result = new ArrayList<>();
    int i = 0;
    int j = 0;

    while (i < a.size() && j < b.size()) {
      int compare = a.get(i).compareTo(b.get(j));

      if (compare == 0) {
        result.add(a.get(i));
        i++;
        j++;
      }
      else if (compare < 0) {
        i++;
      }
      else {
        j++;
      }
    }

    return result;
  }
}
// TC: O(list1.len + ... + listk.len); SC: O(max(list1, ..., listk).len)

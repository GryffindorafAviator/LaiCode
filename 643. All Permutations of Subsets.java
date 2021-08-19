// Medium
// Given a string with no duplicate characters, 
// return a list with all permutations of the string and all its subsets.

// Examples

// Set = “abc”, all permutations are [“”, “a”, “ab”, “abc”, “ac”, “acb”, “b”, “ba”, “bac”, “bc”, “bca”, “c”, “cb”, “cba”, “ca”, “cab”].

// Set = “”, all permutations are [“”].

// Set = null, all permutations are [].

public class Solution {
  public List<String> allPermutationsOfSubsets(String set) {
    List<String> ans = new ArrayList<>();

    if (set == null) {
      return ans;
    }

    char[] chSet = set.toCharArray();
    
    helper(chSet, 0, ans);

    return ans;    
  }

  private void helper(char[] chSet, int index, List<String> ans) {
    ans.add(new String(chSet, 0, index));

    for (int i = index; i < chSet.length; ++i) {
      swap(chSet, index, i);
      helper(chSet, index + 1, ans);
      swap(chSet, index, i);
    }
  }

  private void swap(char[] chSet, int i, int j) {
    char temp = chSet[i];
    chSet[i] = chSet[j];
    chSet[j] = temp;
  }

}

// TC: O(), SC: O(n)


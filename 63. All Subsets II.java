// Hard
// Given a set of characters represented by a String, 
// return a list containing all subsets of the characters. 
// Notice that each subset returned will be sorted to remove the sequence.

// Assumptions

// There could be duplicate characters in the original set.
// Examples

// Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
// Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
// Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
// Set = "", all the subsets are [""]
// Set = null, all the subsets are []

public class Solution {
  public List<String> subSets(String set) {
    List<String> ans = new ArrayList<>();

    if (set == null) {
      return ans;
    }

    char[] setArr = set.toCharArray();
    StringBuilder sb = new StringBuilder();
   
    Arrays.sort(setArr);
    helper(setArr, ans, 0, sb);
    
    return ans;
  }

  private void helper(char[] setArr, List<String> ans, int index, StringBuilder sb) {
    if (index == setArr.length) {
      ans.add(sb.toString());
      
      return;
    }

    helper(setArr, ans, index + 1, sb.append(setArr[index]));
    sb.deleteCharAt(sb.length() - 1);

    while (index < (setArr.length - 1) && setArr[index] == setArr[index + 1]) {
      ++index;
    }

    helper(setArr, ans, index + 1, sb);
  }
}

// TC: O(2^n), SC: O(n)

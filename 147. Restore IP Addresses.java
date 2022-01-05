// Medium
// Given a string containing only digits, 
// restore it by retiring all possible valid IP address combinations.

// Input:  ”25525511135”
// Output: [“255.255.11.135”, “255.255.111.35”]

// Solution
public class Solution {
  public List<String> Restore(String ip) {
    List<String> ans = new ArrayList<>();

    if (ip == null || ip.length() == 0) {
      return ans;
    }

    StringBuilder sb = new StringBuilder();
    char[] ipDigits = ip.toCharArray();

    helper(ipDigits, sb, 0, 0, ans);

    return ans;
  }

  private void helper(char[] ipDigits, StringBuilder sb, int level, int offset, List<String> ans) {
    if (level == 4) {
      if (sb.length() == ipDigits.length + 4) {
        ans.add(sb.substring(0, sb.length() - 1));
      }

      return;
    }

    if (offset < ipDigits.length) {
      helper(ipDigits, sb.append(ipDigits[offset]).append('.'), level + 1, offset + 1, ans);

      sb.delete(sb.length() - 2, sb.length());
    }

    if (offset + 1 < ipDigits.length) {
      char a = ipDigits[offset];
      char b = ipDigits[offset + 1];

      if (a != '0') {
        helper(ipDigits, sb.append(a).append(b).append('.'), level + 1, offset + 2, ans);

        sb.delete(sb.length() - 3, sb.length());
      }
    }

    if (offset + 2 < ipDigits.length) {
      char a = ipDigits[offset];
      char b = ipDigits[offset + 1];
      char c = ipDigits[offset + 2];

      if (a == '1' || (a == '2' && b >= '0' && b <='4') || (a == '2' && b == '5' && c >= '0' && c <= '5')) {
        helper(ipDigits, sb.append(a).append(b).append(c).append('.'), level + 1, offset + 3, ans);

        sb.delete(sb.length() - 4, sb.length());
      }
    }
  }
}
// TC: O(3^4); SC: O(4)

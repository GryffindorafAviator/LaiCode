// Easy
// Only reverse the vowels('a', 'e', 'i', 'o', 'u') in a given string, 
// the other characters should not be moved or changed.

// Assumptions:
// The given string is not null, 
// and only contains lower case letters.
  
// Examples:
// "abbegi" --> "ibbega"
  
// Solution
public class Solution {
  public String reverse(String input) {
    char[] chArr = input.toCharArray();
    int left = 0;
    int right = input.length() - 1;
    Character[] voArr = new Character[] {'a', 'e', 'i', 'o', 'u'};
    Set<Character> vowels = new HashSet<>(Arrays.asList(voArr));

    while (left < right) {
      if (vowels.contains(chArr[left])) {
        while (left < right && !vowels.contains(chArr[right])) {
          right--;
        }

        if (left < right) {
          swap(chArr, left, right);
          left++;
          right--;
        }    
      }
      else {
        left++;
      }
    }

    return String.valueOf(chArr);
  }

  private void swap(char[] chArr, int i, int j) {
    char temp = chArr[i];
    chArr[i] = chArr[j];
    chArr[j] = temp;
  }
}
// TC: O(n); SC: O(n)

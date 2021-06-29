// Medium
// Given a word and a dictionary, 
// determine if it can be composed by concatenating words from the given dictionary.

// Assumptions

// The given word is not null and is not empty
// The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty
// Examples

// Dictionary: {“bob”, “cat”, “rob”}

// Word: “robob” return false

// Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
  
public class Solution {
  public boolean canBreak(String input, String[] dict) {
    Set<String> wordSet = wordSet(dict);

    boolean[] wordTable = new boolean[input.length() + 1];
    wordTable[0] = true;

    for (int i = 1; i < wordTable.length; ++i) {
      for (int j = 0; j < i; ++j) {
        if (wordSet.contains(input.substring(j, i)) && wordTable[j]) {
          wordTable[i] = true;
          break;
        }
      }
    }

    return wordTable[wordTable.length - 1];
  }

  private Set<String> wordSet(String[] dict) {
    Set<String> wordSet = new HashSet<>();

    for (String word : dict) {
      wordSet.add(word);
    }

    return wordSet;
  }
}

// TC: O(n^3), SC: O(n)
// input.substring(), set.contains() are O(n) operation

// Medium
// Given a begin word, an end word and a dictionary, 
// find the least number transformations from begin word to end word, 
// and return the length of the transformation sequence. 
// Return 0 if there is no such transformations.

// In each transformation, 
// you can only change one letter, 
// and the word should still in the dictionary after each transformation. 

// Assumptions
// 1. All words have the same length.
// 2. All words contain only lowercase alphabetic characters.
// 3. There is no duplicates in the word list.
// 4.The beginWord and endWord are non-empty and are not the same.

// Example: 
// start = "git", 
// end = "hot", 
// dictionary = {"git","hit","hog","hot"}
// Output: 3

// Explanation: 
// git -> hit -> hot

// Solution
public class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (beginWord == null || endWord == null || wordList == null) {
      return 0;
    }
        
    int len = beginWord.length();
    int lenEnd = endWord.length();
    int lenList = wordList.size();
    
    if (len == 0 || lenEnd == 0 || lenList == 0) {
      return 0;
    }
    
    Set<String> visited = new HashSet<>();
    Set<String> wordMap = wordMap(wordList);
    Queue<String> q = new LinkedList<>();
    int cnt = 0;
    
    q.offer(beginWord);
    visited.add(beginWord);
    
    int size = q.size();
    
    while (!q.isEmpty()) {
      int tempSize = 0;
      
      cnt++;
      
      for (int i = 0; i < size; i++) {
        String cur = q.poll();
        
        if (cur.equals(endWord)) {
          return cnt;
        }
        
        List<String> nextWords = searchWords(cur, len, wordMap);
      
        for (String word : nextWords) {
          if (!visited.contains(word)) {
            q.offer(word);
            visited.add(word);
            tempSize++;
          }
        } 
      } 

      size = tempSize;
    }
    
    return 0;
  }

  private List<String> searchWords(String cur, int len, Set<String> wordMap) {
    char[] curCh = cur.toCharArray();
    char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    List<String> words = new LinkedList<>();
    int TWENTY_SIX = 26;
    
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < TWENTY_SIX; j++) {
        char[] temp = Arrays.copyOf(curCh, len);
        
        if (temp[i] == alphabet[j]) {
          continue;
        }
        
        temp[i] = alphabet[j];
        String newWord = new String(temp);
        
        if (wordMap.contains(newWord)) {
          words.add(newWord);
        }
      }
    }
    
    return words;
  }
    
  private Set<String> wordMap(List<String> wordList) {
    Set<String> wordMap = new HashSet<>();
    
    for (String word : wordList) {
      wordMap.add(word);
    }
    
    return wordMap;
  } 
}
// TC: O(m * n); SC: O(m * n) 

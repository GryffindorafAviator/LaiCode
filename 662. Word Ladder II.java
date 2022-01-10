// Medium
// Given a begin word, 
// an end word and a dictionary, 
// find the least number transformations from begin word to end word, 
// and return the transformation sequences. 
// Return empty list if there is no such transformations.

// In each transformation, 
// you can only change one letter, 
// and the word should still in the dictionary after each transformation. 

// Assumptions
// 1. All words have the same length.
// 2. All words contain only lowercase alphabetic characters.
// 3. There is no duplicates in the word list.
// 4.The beginWord and endWord are non-empty and are not the same.

// Example: start = "git", end = "hot", 
// dictionary = {"git","hit","hog","hot","got"}
// Output: [["git","hit","hot"], ["git","got","hot"]]

// Solution
public class Solution {
  static class NeighborFinder {
    private List<String> words;
    private Map<String, Integer> wordIndex = new HashMap<>();

    public NeighborFinder(List<String> words) {
      this.words = words;

      for (int i = 0; i < words.size(); i++) {
        String word = words.get(i);

        wordIndex.put(word, i);
      }
    }

    public List<Integer> findNeighbors(int i) {
      List<Integer> neighbors = new ArrayList<>();
      String word = words.get(i);
      StringBuilder wordModifier = new StringBuilder(word);

      for (int j = 0; j < wordModifier.length(); j++) {
        char orig = word.charAt(j);

        for (char ch = 'a'; ch <='z'; ch++) {
          if (orig == ch) {
            continue;
          }

          wordModifier.setCharAt(j, ch);

          int neighbor = wordIndex.getOrDefault(wordModifier.toString(), -1);

          if (neighbor != -1) {
            neighbors.add(neighbor);
          }
        }

        wordModifier.setCharAt(j, orig);
      }

      return neighbors;
    }
  }

  static class Tracer {
    private List<String> words;
    private List<List<Integer>> preds;

    public Tracer(List<String> words) {
      this.words = words;
      preds = new ArrayList<>();

      for (int i = 0; i < words.size(); i++) {
        preds.add(new ArrayList<>());
      }
    }

    public void addPredecessor(int pre, int cur) {
      preds.get(cur).add(pre);
    }

    public List<List<String>> findLadders(int beginIndex, int endIndex) {
      List<List<String>> ladders = new ArrayList<>();
      List<String> trace = new ArrayList<>();

      trace.add(words.get(endIndex));
      findLaddersHelper(beginIndex, endIndex, trace, ladders);

      return ladders;
    }

    public void findLaddersHelper(int beginIndex, int endIndex, List<String> trace, List<List<String>> ladders) {
      if (beginIndex == endIndex) {
        List<String> ladder = new ArrayList<>(trace);
        Collections.reverse(ladder);

        ladders.add(ladder);

        return;
      }

      for (int pred : preds.get(endIndex)) {
        trace.add(words.get(pred));
        findLaddersHelper(beginIndex, pred, trace, ladders);
        trace.remove(trace.size() - 1);
      }
    }
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      int endIndex = wordList.indexOf(endWord);

      if (endIndex == -1) {
        return new ArrayList<>();
      }

      List<String> words;
      int beginIndex = wordList.indexOf(beginWord);

      if (beginIndex == -1) {
        words = new ArrayList<>(wordList);

        words.add(beginWord);
        beginIndex = words.size() - 1;
      }
      else {
        words = wordList;
      }

      NeighborFinder finder = new NeighborFinder(words);
      Tracer tracer = new Tracer(words);

      Queue<Integer> queue = new ArrayDeque<>();
      int[] steps = new int[words.size()];
      Arrays.fill(steps, -1);

      queue.offer(beginIndex);
      steps[beginIndex] = 0;

      while (!queue.isEmpty()) {
        int x = queue.poll();

        if (x == endIndex) {
          return tracer.findLadders(beginIndex, endIndex);
        }

        for (int neighbor : finder.findNeighbors(x)) {
          if (steps[neighbor] == -1) {
            queue.offer(neighbor);
            steps[neighbor] = steps[x] + 1;
          }

          if (steps[neighbor] == steps[x] + 1) {
            tracer.addPredecessor(x, neighbor);
          }
        }
      }

      return new ArrayList<>();
  }
}
// TC:

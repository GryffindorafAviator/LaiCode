// Medium
// Given a stream of characters, 
// find the first non-repeating character from stream. 
// You need to tell the first non-repeating character in O(1) time at any moment.

// Implement two methods of the class:
// read() - read one character from the stream
// firstNonRepeating() - return the first non-repoeating character from the stream at any time when calling the method, 
// return null if there does not exist such characters

// Examples:
// read:
// a   b   c   a   c   c    b
// firstNonRepeating:
// a   a   a   b   b   b   null

// Solution
public class Solution {
  static class Node {
    Node prev;
    Node next;
    Character ch;

    Node(Character ch) {
      this.ch = ch;
    }
  }

  private Node head;
  private Node tail;
  private Set<Character> repeated;
  private Map<Character, Node> singled;

  public Solution() {
    head = new Node(null);
    head.prev = head.next = head;
    tail = head;
    repeated = new HashSet<>();
    singled = new HashMap<>();
  }
  
  public void read(char ch) {
    if (repeated.contains(ch)) {
      return;
    }

    Node node = singled.get(ch);

    if (node == null) {
      node = new Node(ch);

      append(node);   
    }
    else {
      remove(node);
    }
  }

  private void append(Node node) {
    singled.put(node.ch, node);
    tail.next = node;
    node.prev = tail;
    node.next = head;
    tail = tail.next;
  }

  private void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;

    if (node == tail) {
      tail = node.prev;
    }

    node.prev = node.next = null;

    singled.remove(node.ch);
    repeated.add(node.ch);
  }
  
  public Character firstNonRepeating() {
    if (head == tail) {
      return null;
    }

    return head.next.ch;  
  }
}
// TC: O(1); SC: O(stream.len)

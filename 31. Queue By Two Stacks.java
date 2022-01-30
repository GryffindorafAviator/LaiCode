// Medium
// Java: Implement a queue by using two stacks. 
// The queue should provide size(), isEmpty(), 
// offer(), poll() and peek() operations. 
// When the queue is empty, poll() and peek() should return null.

// C++: Implement a queue by using two stacks. 
// The queue should provide size(), isEmpty(), 
// push(), front() and pop() operations. When the queue is empty, front() should return -1.

// Assumptions
// The elements in the queue are all Integers.
// size() should return the number of elements buffered in the queue.
// isEmpty() should return true if there is no element buffered in the queue, 
// false otherwise.

// Solution
public class Solution {
  private LinkedList<Integer> in;
  private LinkedList<Integer> out;

  public Solution() {
    in = new LinkedList<>();
    out = new LinkedList<>();
  }
  
  public Integer poll() {
    move();
    return out.isEmpty() ? null : out.pollFirst();
  }
  
  public void offer(int element) {
    in.offerFirst(element);
  }
  
  public Integer peek() {
    move();
    return out.isEmpty() ? null : out.peekFirst();
  }
  
  public int size() {
    return in.size() + out.size();
  }
  
  public boolean isEmpty() {
    return in.isEmpty() && out.isEmpty();
  }

  private void move() {
    if (out.isEmpty()) {
      while (!in.isEmpty()) {
        out.offerFirst(in.pollFirst());
      }
    }
  }
}

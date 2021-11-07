// Medium
// Java: 
// Implement a deque by using three stacks. 
// The queue should provide size(), 
// isEmpty(), 
// offerFirst(), 
// offerLast(), 
// pollFirst(), 
// pollLast(), 
// peekFirst() and peekLast() operations. 
// When the queue is empty, 
// pollFirst(), 
// pollLast(), 
// peekFirst() and peek() should return null.

// Python: 
// Implement a deque by using three stacks. 
// The queue should provide size(), 
// isEmpty(), 
// offerFirst(), 
// offerLast(), 
// pollFirst(), 
// pollLast(), 
// peekFirst() and peekLast() operations. 
// When the queue is empty, 
// pollFirst(), 
// pollLast(), 
// peekFirst() and peek() should return None

// C++: 
// Implement a deque by using three stacks. 
// The queue should provide size(), 
// isEmpty(), 
// push_front(), 
// push_back(), 
// pop_front(), 
// pop_back(), 
// front() and back() operations. 
// When the queue is empty, 
// front() and back() should return -1.

// Assumptions
// The elements in the queue are all Integers.
// size() should return the number of elements buffered in the queue.
// isEmpty() should return true if there is no element buffered in the queue, 
// false otherwise.
  
// The amortized time complexity of all operations should be O(1).

// Solution
public class Solution {
  Deque<Integer> first;
  Deque<Integer> last;
  Deque<Integer> buffer;

  public Solution() {
    first = new ArrayDeque<>();
    last = new ArrayDeque<>();
    buffer = new ArrayDeque<>();
  }
  
  public void offerFirst(int element) {
    first.offerFirst(element);
  }
  
  public void offerLast(int element) {
    last.offerFirst(element);
  }
  
  public Integer pollFirst() {
    move(last, first);

    return first.isEmpty() ? null : first.pollFirst();
  }
  
  public Integer pollLast() {
    move(first, last);

    return last.isEmpty() ? null : last.pollFirst();
  }
  
  public Integer peekFirst() {
    move(last, first);

    return first.isEmpty() ? null : first.peekFirst();
  }
  
  public Integer peekLast() {
    move(first, last);

    return last.isEmpty() ? null : last.peekFirst();
  }
  
  public int size() {
    return first.size() + last.size();
  }
  
  public boolean isEmpty() {
    return first.isEmpty() && last.isEmpty();
  }

  private void move(Deque<Integer> src, Deque<Integer> dstn) {
    if (!dstn.isEmpty()) {
      return;
    }

    if (src.isEmpty()) {
      return;
    }

    int halfSize = src.size() / 2;

    for (int i = 0; i < halfSize; i++) {
      buffer.offerFirst(src.pollFirst());
    }

    while (!src.isEmpty()) {
      dstn.offerFirst(src.pollFirst());
    }

    while (!buffer.isEmpty()) {
      src.offerFirst(buffer.pollFirst());
    }
  }
}

// Medium
// Enhance the stack implementation to support min() operation. 
// min() should return the current minimum value in the stack. 
// If the stack is empty, min() should return -1.

// push(int element) - push the element to top
// pop() - return the top element and remove it, if the stack is empty, return -1
// top() - return the top element without remove it, if the stack is empty, return -1
// min() - return the current min value in the stack.

// Solution
public class Solution {
  private Deque<Integer> s;
  private Deque<Integer> sMin;
  int min;

  public Solution() {
    s = new LinkedList<>();
    sMin = new LinkedList<>();
  }
  
  public int pop() {
    if (s.isEmpty()) {
      return -1;
    }

    sMin.pollFirst();
    return s.pollFirst();
  }
  
  public void push(int element) {
    if (s.isEmpty()) {
      min = element;
    }
    else {
      if (element < min) {
        min = element;
      }
    }

    s.offerFirst(element);
    sMin.offerFirst(min);
  }
  
  public int top() {
    return s.isEmpty() ? -1 : s.peekFirst();
  }
  
  public int min() {
    if (s.isEmpty()) {
      return -1;
    }

    return sMin.peekFirst();
  }
}

// Solution
public class Solution {
  private Deque<Integer> stack;
  private Deque<Integer> minStack;

  public Solution() {
    stack = new LinkedList<>();
    minStack = new LinkedList<>();
  }
  
  public int pop() {
    if (stack.isEmpty()) {
      return -1;
    }

    Integer res = stack.pollFirst();

    if (minStack.peekFirst().equals(res)) {
      minStack.pollFirst();
    }

    return res;
  }
  
  public void push(int element) {
    stack.offerFirst(element);

    if (minStack.isEmpty() || element <= minStack.peekFirst()) {
      minStack.offerFirst(element);
    }  
  }
  
  public int top() {
    return stack.isEmpty() ? -1 : stack.peekFirst();
  }
  
  public int min() {
    if (minStack.isEmpty()) {
      return -1;
    }

    return minStack.peekFirst();
  }
}

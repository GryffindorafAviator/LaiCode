Medium
Enhance the stack implementation to support min() operation. 
min() should return the current minimum value in the stack. 
If the stack is empty, min() should return -1.

push(int element) - push the element to top
pop() - return the top element and remove it, if the stack is empty, return -1
top() - return the top element without remove it, if the stack is empty, return -1
min() - return the current min value in the stack.

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

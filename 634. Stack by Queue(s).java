// Medium
// Implement a stack containing integers using queue(s). 
// The stack should provide push(x), 
// pop(), 
// top() and isEmpty() operations.

// In java: if the stack is empty, 
// then top() and pop() will return null.

// In Python: if the stack is empty, 
// then top() and pop() will return None.

// In C++:  if the stack is empty, 
// then top() and pop() will return nullptr.

// Solution 1, one queue
class Solution {
    private Queue<Integer> q;
    /** Initialize your data structure here. */
    public Solution() {
       q = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        if (q.isEmpty()) {
          return null;
        }

        int size = q.size();

        while (size > 1) {
          q.offer(q.poll());
          size--;
        }

        return q.poll();
    }

    /** Get the top element. */
    public Integer top() {
        if (q.isEmpty()) {
          return null;
        }

        int ans = pop();

        q.offer(ans);

        return ans;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
       return q.isEmpty();
    }
}

// Solution 2, two queues
class Solution {
    Queue<Integer> q1;
    Queue<Integer> q2;
    /** Initialize your data structure here. */
    public Solution() {
       q1 = new ArrayDeque<>();
       q2 = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public Integer pop() {
        Integer prev = q1.poll();
        Integer curr = q1.poll();

        while (curr != null) {
          q2.offer(prev);
          prev = curr;
          curr = q1.poll();
        }

        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;

        return prev;
    }

    /** Get the top element. */
    public Integer top() {
        Integer ans = pop();

        if (ans != null) {
          q1.offer(ans);
        }

        return ans;
    }

    /** Returns whether the stack is empty. */
    public boolean isEmpty() {
      return top() == null;
    }
}

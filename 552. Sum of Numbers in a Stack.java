// Easy
// Calculate the sum of all numbers in a Stack.

// Assumption: The Stack is not null or empty.

// Example: 
// Stack contains 7,5,3,0
// Answer: 15

class Solution {
	public int sumOfStack(Deque<Integer> stack) {
    int sum = 0;

    while (!stack.isEmpty()) {
      sum += stack.pollFirst();
    }

    return sum;
	}
}

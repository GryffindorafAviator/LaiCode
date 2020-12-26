// Easy
// Given two integer a and b, calculate a divide by b but maintain the precision.

class Solution {
	public double divide() {
		int a = 3;
		int b = 7;	
		double c = (double) a / b; 
    
		return c;
	}
}

// Solution
class Solution {
	public double divide() {
		int a = 3;
		int b = 7;
		double c = 1.0 * a / b;
		
		return c;
	}
}

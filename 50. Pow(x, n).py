# Medium
# Implement pow(x, n), 
# which calculates x raised to the power n (i.e., xn).

# Example 1:
# Input: 
# x = 2.00000, n = 10
# Output: 
# 1024.00000

# Example 2:
# Input: 
# x = 2.10000, n = 3
# Output: 
# 9.26100

# Example 3:
# Input: 
# x = 2.00000, n = -2
# Output: 
# 0.25000

# Explanation: 
# 2-2 = 1/22 = 1/4 = 0.25
 
# Constraints:
# -100.0 < x < 100.0
# -231 <= n <= 231-1
# n is an integer.
# -104 <= xn <= 104

# Solution
class Solution:
    def myPow(self, x: float, n: int) -> float:
        ans = self.helper(x, abs(n))

        return float(ans) if n >= 0 else 1 / ans
    
    def helper(self, base, n):
        if n == 0:
            return 1
        
        if n % 2 == 0:
            return self.helper(base * base, n / 2)
        
        if n % 2 == 1:
            return base * self.helper(base * base, (n - 1) / 2)
# TC: O(lgn); SC: O(lgn)
# Accepted

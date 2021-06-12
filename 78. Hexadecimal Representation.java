// Easy
// Generate the hexadecimal representation for a given non-negative integer number as a string. The hex representation should start with "0x".

// There should not be extra zeros on the left side.

// Examples

// 0's hex representation is "0x0"
// 255's hex representation is "0xFF"
  
public class Solution {
  public String hex(int number) {
    if (number == 0) {
      return "0x0";
    }

    char[] hexBase = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    StringBuilder sb = new StringBuilder();

    while (number > 0) {
      sb.append(hexBase[number % 16]);
      number /= 16;
    }

    sb.append("x0");
    sb.reverse();

    return sb.toString();
  }
}

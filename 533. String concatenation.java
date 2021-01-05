Easy
Given two strings, concatenate them into one, separated by a comma.

Example:
first string: “hello”
second string: “world”
result: “hello,world”

public class Solution {
  public String concatenate(String x, String y) {
    String z = x + ',' + y;
    return z;
  }
}

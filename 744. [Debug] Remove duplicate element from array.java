// Debug
// There are bugs in the given code, please fix them.

// Given a 1D array and a known duplicate element (which appears more than once), 
// remove the duplicate element and return the result array.

// Input: array = [2, 3, 3, 4, 5], duplicate = 3
// Output: [2, 4, 5]

// Assume
// (1) the input array is not null or empty 
// (2) the duplicate element always exists in the input array and there is only one duplicate element.

public class Solution {
 public int[] removeDuplicate(int[] array, int duplicate) {
   int count = 0;
   for (int i = 0; i < array.length; i++) {
     if (array[i] == duplicate) {
       count++;
     }
   }
   int[] result = new int[array.length - count];
   int i = 0;
   int j = 0;
   while (i < array.length) {
     if (array[i] == duplicate) {
       i++;
     } else {
       result[j] = array[i];
       i++;
       j++;
     }
   }
   return result;
 }
}

// Find the largest palindrome made from the product of two 3 digit numbers

import java.util.*;

class PalindromeProduct {
  public static void main(String[] args) {
    System.out.println(palindromeProduct(3));
  }

  // Given n, find the largest palindrome made from the product
  // of two n digit numbers
  // Note: Gonna just brute force this at first
  public static int palindromeProduct(int n) {
    int start = (int)Math.pow(10, n) - 1;
    int lowerLimit = (int)Math.pow(10, n-1) - 1;
    int maxPalin = -1;
    while (lowerLimit < start) {
      for (int j = start; lowerLimit < j; j--) {
        if(isPalindrome(Integer.toString(j * start))) maxPalin = Math.max(maxPalin, j * start);
      }
      start--;
    }
    return maxPalin;
  }

  public static boolean isPalindrome(String s) {
    int start = 0;
    int end = s.length() - 1;
    while(start < end) {
      if (s.charAt(start) != s.charAt(end)) return false;
      start++;
      end--;
    }
    return true;
  }
}

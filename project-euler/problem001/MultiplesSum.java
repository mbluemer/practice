import java.util.*;
// Find the sum of all multiples of 3 or 5 below 1000

class MultiplesSum {
  public static void main(String[] args) {
    System.out.println("The sum of all multiples of 3 or 5 below 1000 is: " + iterSummation(1000));
    System.out.println("Other test: " + multiplesSum(1000));
  }

  // Attempt at a O(1) solution. Can't seem to figure out why the answer is off...
  public static int multiplesSum(int n) {
    int ft = n / 15;
    int f = n / 5;
    int t = n / 3;
    return 5 * nSummation(f - ft) + 3 * nSummation(t - ft) + 15 * nSummation(ft);
  }

  // Given an integer n, return the sum from 0 to n
  public static int nSummation(int n) {
    return (n * (n + 1)) / 2;
  }

  // Simple O(n) solution via iteration
  public static int iterSummation(int n) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      if (i % 3 == 0 || i % 5  == 0) sum += i;
    }
    return sum;
  }
}

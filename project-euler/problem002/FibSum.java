// By considering the terms in the fibonacci sequence that do not
// exceed four million, find the sum of the even valued terms

class FibSum {
  public static void main(String[] args) {
    System.out.print(fibSum(4000000));
  }

  // Given n, find the sum of all fib numbers
  // that don't exceed n
  public static int fibSum(int n) {
    int sum = 0;
    int fib1 = 1;
    int fib2 = 1;
    for (int i = 3; fib2 < n; i++) {
      int x = fib1 + fib2;
      fib1 = fib2;
      fib2 = x;
      if (fib2 % 2 == 0) sum += fib2;
    }
    return sum;
  }
}

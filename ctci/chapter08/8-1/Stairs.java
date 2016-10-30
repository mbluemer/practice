import java.util.*;

class Main {
  // You can run up a case on n stairs either 1, 2, or 3 stairs at a time
  // How many possible ways are there?
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Please input some number: ");
    int test = in.nextInt();
    if (test > 39) System.out.println("Sorry this is too big for an integer to hold.");
    else System.out.println("There are " + stairCountIter(test) + " possible ways.");
  }

  public static int stairCountRec(int n) {
    if (n == 0 || n == 1) return 1;
    else if (n == 2) return 2;
    else return stairCountRec(n-1) + stairCountRec(n-2) + stairCountRec(n-3);
  }

  public static int stairCountIter(int n) {
    int[] res = new int[n+1];
    res[0] = res[1] = 1;
    res[2] = 2;
    for (int i = 3; i <= n; i++) {
      res[i] = res[i-1] + res[i-2] + res[i-3];
    }
    return res[n];
  }
}

import java.util.*;

class Main {
  public static void main(String[] args) {
    int[] testDenoms = new int[]{1, 5, 10, 25};
    Scanner in = new Scanner(System.in);
    System.out.println("Please input a number: ");
    int testNum = in.nextInt();
    System.out.println("There are " + coinCombinationsRec(testDenoms, testNum) + " ways to change");
    System.out.println("There are " + coinCombinationsIter(testDenoms, testNum) + " ways to change");
  }

  // Given a certain set of coin denominations come up with the number
  // of ways you can create n cents
  public static int coinCombinationsRec(int[] denoms, int n) {
    return coinCombinationsRec(denoms, n, denoms.length - 1);
  }

  public static int coinCombinationsRec(int[] denoms, int n, int index) {
    if (n < 0 || index < 0) return 0;
    else if (n == 0) return 1;
    else {
      return coinCombinationsRec(denoms, n - denoms[index], index) + coinCombinationsRec(denoms, n, index - 1);
    }
  }

  public static int coinCombinationsIter(int[] denoms, int n) {
    int[][] M = new int[denoms.length][n+1];
    // When n = 0 there's 1 way to create the denomination
    for (int i = 0; i < denoms.length; i++) 
      M[i][0] = 1;
    // Initialize the row of the first denomination
    for (int i = denoms[0]; i <= n; i++)
      M[0][i] = 1;
    // Now we can calculate the rest of them
    for (int i = 1; i < denoms.length; i++) {
      for (int j = 1; j <= n; j++) {
        if (j < denoms[i]) M[i][j] = M[i-1][j];
        else M[i][j] = M[i][j-denoms[i]] + M[i-1][j];
      }
    }
    return M[denoms.length-1][n];
  }
}

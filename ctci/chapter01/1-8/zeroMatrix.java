import java.util.*;


class Pair {
  int x;
  int y;

  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Main {
  public static void main(String[] args) {
    int[][] test = {{1, 2, 3, 4}, {0, 5, 3, 2}, {8, 5, 3, 0}, {5, 5, 5, 5}, {2, 3, 4, 5}};
    printMatrix(test);
    zeroMatrix(test);
    System.out.println("-----------------------");
    printMatrix(test);
  }

  public static int[][] zeroMatrix(int[][] M) {
    List<Pair> pairList = new ArrayList<Pair>();
    for (int i = 0; i < M.length; i++) {
      for (int j = 0; j < M[i].length; j++) {
        if (M[i][j] == 0) pairList.add(new Pair(i, j));
      }
    }
    for (Pair p : pairList) {
      for (int i = 0; i < M[p.x].length; i++)
        M[p.x][i] = 0;
      for (int i = 0; i < M.length; i++)
        M[i][p.y] = 0;
    }
    return M;
  }

  public static void printMatrix(int[][] M) {
    for (int i = 0; i < M.length; i++) {
      for (int j = 0; j < M[i].length; j++) {
        System.out.print(M[i][j] + "  ");
      }
      System.out.println();
    }
  }
}

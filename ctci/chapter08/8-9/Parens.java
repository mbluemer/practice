import java.util.*;

class Main {
  public static void main(String[] args) {
    printParens(4);
  }

  public static void printParens(int n) {
    List<String> prevLine = new ArrayList<String>();
    for (int i = 0; i <= n; i++) {
      List<String> currLine = new ArrayList<String>();
      if (i==1) {
        currLine.add("()");
      } else {
        for (int j = 0; j < prevLine.size(); j++) {
          currLine.add("()" + prevLine.get(j));
          if (j != 0) currLine.add(prevLine.get(j) + "()");
          currLine.add("(" + prevLine.get(j) + ")");
        }
      }
      for (String s : currLine) {
        System.out.print(s+'|');
      }
      System.out.println();
      prevLine = currLine;
    }
  }
}

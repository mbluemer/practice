import java.util.*;

class Main {
  public static void main(String[] args) {
    List<Integer> test = new ArrayList<Integer>();
    test.add(1);
    test.add(2);
    test.add(3);
    List<List<Integer>> testRes = genPowerset(test);
    for (List<Integer> lst : testRes) {
      for (int x : lst) {
        System.out.print(x + " ");
      }
      System.out.println();
    }
  }

  public static List<List<Integer>> genPowerset(List<Integer> set) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    res.add(new ArrayList<Integer>());
    for (int x : set) {
      int currSize = res.size();
      for (int i = 0; i < currSize; i++) {
        List<Integer> newLst = new ArrayList<Integer>(res.get(i));
        newLst.add(x);
        res.add(newLst);
      }
    }
    return res;
  }
}

import java.util.*;

class Main {
  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Input string: ");
    String test = in.next();
    System.out.println(isUnique(test));
  }

  public static boolean isUnique(String s) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      if (!map.containsKey(s.charAt(i))) {
        map.put(s.charAt(i), 1);
      } else {
        return false;
      }
    }
     return true;
  }
}

import java.util.*;

class Main {
  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter two words:");
    String s1 = in.next();
    String s2 = in.next();
    System.out.println(isPermuation(s1, s2));
  }

  static boolean isPermuation(String s1, String s2) {
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < s1.length(); i++) {
      char c = s1.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c)+1);
      } else {
        map.put(c, 1);
      }
    }
    for (int i = 0; i < s2.length(); i++) {
      char c = s2.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c)-1);
      }
    }

    for (int i : map.values()) {
      if (i != 0) return false;
    }
    return true;
  }
}

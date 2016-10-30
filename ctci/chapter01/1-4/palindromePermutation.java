import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter a string:");
    String test = in.nextLine();
    if (isPalindromePermutation(test)) {
      System.out.println("This is a palindrome permutation.");
    } else {
      System.out.println("This is not a palindrome permutation.");
    }
  }

  public static boolean isPalindromePermutation(String s) {
    // First remove all spaces
    s = s.replaceAll(" ","");
    
    // Map number of each character
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (map.containsKey(c))
        map.put(c, map.get(c) + 1);
      else
        map.put(c, 1);
    }

    // Check values in the map
    boolean oddFound = false;
    for (int x : map.values()) {
      if (x % 2 != 0) {
        if (s.length() % 2 != 0 && !oddFound)
          oddFound = true;
        else
          return false;
      }
    }

    return true;
  }
}

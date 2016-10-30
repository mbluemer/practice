import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter input string: ");
    String test = in.next();
    System.out.println(StringCompress(test));
  }

  public static String StringCompress(String s) {
    StringBuilder out = new StringBuilder();
    char currChar = s.charAt(0);
    int charCount = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == currChar) {
        charCount++;
      } else {
        out.append(currChar);
        out.append(charCount);
        charCount = 1;
        currChar = s.charAt(i);
      }
    }
    out.append(currChar);
    out.append(charCount);

    return (out.length() < s.length()) ? out.toString() : s;
  }
}

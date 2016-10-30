import java.util.*;

class Main {
  public static void main (String[] args) {
    // Take in string for test
    System.out.println("Please enter line:");
    Scanner in = new Scanner(System.in);
    String test = in.nextLine();
    // Create char array for string and make sure to add spaces
    int spaces = test.length() - test.replace(" ", "").length();
    char[] testArr = new char[test.length() + spaces];
   for (int i = 0; i < test.length(); i++) {
     testArr[i] = test.charAt(i);
   } 

   for (int i = test.length(); i < testArr.length; i++) {
     testArr[i] = ' ';
   }

   System.out.println(new String(urlify(testArr, test.length())));
  }

  // Given a character array with correct amount of space padding on the end
  // and an integer that is the length of the original string
  // return the urlified char array (spaces turned to '%20' )
  static char[] urlify (char[] s, int n) {
    char[] res = new char[s.length];
    for (int i = 0; i < n; i++) {
      if (s[i] == ' ') {
        res[i] = '%';
        res[i+1] = '2';
        res[i+2] = '0';
      } else {
        res[i] = s[i];
      }
    }
    return res;
  }
}

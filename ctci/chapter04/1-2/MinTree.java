import java.util.*;

class Node {
  int val;
  Node left;
  Node right;

  public Node(int n) {
    this.val = n;
  }
}
class MinTree {
  public static void main (String args[]) {
    int[] test = new int[]{1, 2, 3, 4, 5, 6, 7};
    Node root = minTree(test);
    inOrderTraversal(root);
    System.out.println(maxHeight(root));
  }

  public static Node minTree(int nums[]) {
    return minTree(nums, 0, nums.length+1);
  }

  // given a list of integers sorted in ascending order return the min height BST
  public static Node minTree(int nums[], int start, int end) {
    if (end-start < 2) return null;
    int mid = (end + start) / 2;
    Node n = new Node(nums[mid-1]);
    n.left = minTree(nums, start, mid);
    n.right = minTree(nums, mid, end);
    return n;
  }

  // used to test to make sure the tree is min height
  public static void inOrderTraversal(Node n) {
    if (n == null) return;
    inOrderTraversal(n.left);
    System.out.println(n.val);
    inOrderTraversal(n.right);
  }
  
  // Also used for testing
  public static int maxHeight(Node n) {
    if (n == null) return 0;
    else return 1 + Math.max(maxHeight(n.left), maxHeight(n.right));
  }
}

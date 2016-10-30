import java.util.*;

class Node {
  int val;
  Node next;

  public Node(int x) {
    this.val = x;
    this.next = null;
  }
}

class Main {
  public static void main(String[] args) {
    Node t1 = new Node(3);
    Node t2 = new Node(1);
    Node t3 = new Node(8);
    Node t4 = new Node(3);
    Node t5 = new Node(8);
    Node t6 = new Node(9);
    t1.next = t2; t2.next = t3; t3.next = t4; t4.next = t5; t5.next = t6;
    printList(t1);
    System.out.println();
    removeDups(t1);
    printList(t1);
    System.out.println();
  }

  public static Node removeDups(Node root) {
    if (root == null || root.next == null) return root;
    Set<Integer> set = new HashSet<Integer>();
    Node prev;
    Node cur = root;
    Node next = root.next;
    set.add(cur.val);
    while (next != null) {
      if (!set.contains(next.val)) {
        set.add(next.val);
        prev = cur;
        cur = next;
        next = next.next;
      } else {
        cur.next = next.next;
        next = cur.next;
      }
    }
    return root;
  }

  public static void printList(Node root) {
    if (root == null) return;
    System.out.print(root.val+"->");
    printList(root.next);
  }
}

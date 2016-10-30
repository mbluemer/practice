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
    Node t1 = new Node(1);
    Node t2 = new Node(2);
    Node t3 = new Node(3);
    Node t4 = new Node(4);
    Node t5 = new Node(5);
    Node t6 = new Node(6);
    t1.next = t2; t2.next = t3; t3.next = t4; t4.next = t5; t5.next = t6;
    listPrint(t1);
    System.out.println(kthFromEnd(t1, 4));
  }

  public static int kthFromEnd(Node root, int k) {
    if (root == null) return -1;
    Node runner = root;
    while (runner != null) {
      if (k <= 0) root = root.next;
      runner = runner.next;
      k--;
    }
    return root.val;
  }

  public static void listPrint(Node root) {
    if (root == null) {
      System.out.println();
      return;
    } else {
      System.out.print(root.val+"->");
      listPrint(root.next);
    }
  }
}

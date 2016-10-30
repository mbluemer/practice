import java.util.*;

class Node {
  List<Node> adjacencyList;

  public Node() {
    adjacencyList = new ArrayList<Node>();
  }
}

class Main {
  public static void main(String args[]) {
    Node n1 = new Node();
    Node n2 = new Node();
    Node n3 = new Node();
    Node n4 = new Node();
    Node n5 = new Node();
    Node n6 = new Node();
    Node n7 = new Node();
    n1.adjacencyList.add(n2);
    n1.adjacencyList.add(n3);
    n2.adjacencyList.add(n4);
    n4.adjacencyList.add(n5);
    n4.adjacencyList.add(n6);
    n6.adjacencyList.add(n7);
    n7.adjacencyList.add(n6);
    System.out.println(routeExists(n1, n6));
  }


  public static boolean routeExists(Node s, Node t) {
    Set<Node> visited = new HashSet<Node>();
    Queue<Node> Q = new ArrayDeque<Node>();
    Q.add(s);
    visited.add(s);
    while (!Q.isEmpty()) {
      Node cur = Q.remove();
      for (Node n : cur.adjacencyList) {
        if (n == t) return true;
        else if (!visited.contains(n)) {
          visited.add(n);
          Q.add(n);
        }
      }
    }
    return false;
  }
}

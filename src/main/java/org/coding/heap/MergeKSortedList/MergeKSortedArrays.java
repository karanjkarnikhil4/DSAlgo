package org.coding.heap.MergeKSortedList;

// { Driver Code Starts
import java.util.*;

class Node {
  int data;
  Node next;

  Node(int key) {
    data = key;
    next = null;
  }
}

class GfG {
  public static void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    while (t-- > 0) {
      int N = sc.nextInt();

      Node[] a = new Node[N];

      for (int i = 0; i < N; i++) {
        int n = sc.nextInt();

        Node head = new Node(sc.nextInt());
        Node tail = head;

        for (int j = 0; j < n - 1; j++) {
          tail.next = new Node(sc.nextInt());
          tail = tail.next;
        }

        a[i] = head;
      }

      Merge g = new Merge();

      Node res = g.mergeKList(a, N);
      if (res != null) printList(res);
      System.out.println();
    }
  }
} // } Driver Code Ends

/*class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a

class Merge {
  Node mergeKList(Node[] a, int N) {
    // Add your code here.
    Queue<Node> priorityQueue =
        new PriorityQueue<>(
            (o1, o2) -> {
              if (o1.data > o2.data) {
                return 1;
              } else if (o1.data < o2.data) {
                return -1;
              } else {
                return 0;
              }
            });
    Node root = null;

    for (int i = 0; i < N; i++) {
      priorityQueue.add(a[i]);
    }

    root = priorityQueue.peek();
    Node previousNode = null;

    while (priorityQueue.size() > 0) {

      Node currentNode = priorityQueue.poll();
      if (previousNode == null) {
        previousNode = currentNode;
      } else {
        previousNode.next = currentNode;
        previousNode = currentNode;
      }
      while (currentNode.next == null && priorityQueue.size() > 0) {
        currentNode = priorityQueue.poll();
        previousNode.next = currentNode;
        previousNode = currentNode;
      }

      if (currentNode.next != null) priorityQueue.add(currentNode.next);
    }

    return root;
  }
}

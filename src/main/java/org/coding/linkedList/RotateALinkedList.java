package org.coding.linkedList;// { Driver Code Starts

import java.util.Scanner;
//class Node {
//    int data;
//    Node next;
//    Node(int d) {
//        data = d;
//        next = null;
//    }
//}

public class RotateALinkedList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int a = sc.nextInt();
            Node head = new Node(a);
            Node tail = head;

            for (int i = 0; i < n - 1; i++) {
                a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();

            Rotate g = new Rotate();
            head = g.rotate(head, k);
            printList(head);
        }
    }

    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}
// } Driver Code Ends



/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Rotate {
    // This function should rotate list counter-
    // clockwise by k and return head node

    public Node rotate(Node head, int k) {
        // add code here

        int lengthOfLinkedList = 0;

        Node lengthNode = head;
        Node forwardNode = head;
        Node currentNode =head;

        while (lengthNode != null) {
            lengthOfLinkedList++;
            lengthNode = lengthNode.next;
        }

        if (lengthOfLinkedList == 0 || lengthOfLinkedList == 1) {
            return head;
        }
//
//        if (k > lengthOfLinkedList) {
//            k = k % lengthOfLinkedList;
//        }

        int count = lengthOfLinkedList -k;


        while (count > 0) {
            forwardNode = forwardNode.next;
            count--;
        }

        while(forwardNode.next!=null)
        {
            currentNode = currentNode.next;
            forwardNode = forwardNode.next;
        }

        forwardNode.next = head;
        head = currentNode.next;
        currentNode.next= null;

        return head;
    }
}

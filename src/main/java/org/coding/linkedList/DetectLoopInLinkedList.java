package org.coding.linkedList;


// { Driver Code Starts
// driver code

import java.util.Scanner;

//class Node
//{
//    int data;
//    Node next;
//
//    Node(int x)
//    {
//        data = x;
//        next = null;
//    }
//}

public class DetectLoopInLinkedList {
    public static void makeLoop(Node head, Node tail, int x) {
        if (x == 0) return;

        Node curr = head;
        for (int i = 1; i < x; i++)
            curr = curr.next;

        tail.next = curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;

            for (int i = 0; i < n - 1; i++) {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }

            int pos = sc.nextInt();
            makeLoop(head, tail, pos);

            Solution1 x = new Solution1();
            if (x.detectLoop(head))
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}
// } Driver Code Ends


/* Node is defined as

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/


class Solution1 {
    public static boolean detectLoop(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        boolean isLoop = false;
        boolean firstDetection = false;

        while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
            if (slowPointer == fastPointer) {
                if (!firstDetection) {
                    firstDetection = true;
                } else {
                    isLoop = true;
                    break;
                }

            }


            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

        }
        return isLoop;
    }


}

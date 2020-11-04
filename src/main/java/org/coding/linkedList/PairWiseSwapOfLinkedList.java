package org.coding.linkedList;


// { Driver Code Starts

import java.io.IOException;
import java.util.Scanner;

//class Node{
//    int data;
//    Node next;
//
//    Node(int x){
//        data = x;
//        next = null;
//    }
//
//}
class PairWiseSwapOfLinkedList {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();

            Node head = new Node(sc.nextInt());
            Node tail = head;
            for (int i = 0; i < n - 1; i++) {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }

            Solution2 g = new Solution2();
            head = g.pairwiseSwap(head);
            printList(head);
            t--;
        }
    }
}

// } Driver Code Ends



/* node class of the linked list

class Node
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


class Solution2 {
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head) {
        int  evenOddNumer =1;
        Node previousNode = null;
        Node currentNode = head;

        while(currentNode!=null)
        {
            if(evenOddNumer % 2 == 0)
            {
                int temp = previousNode.data;
                previousNode.data = currentNode.data;
                currentNode.data = temp;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
            evenOddNumer++;
        }

        return head;
    }
}

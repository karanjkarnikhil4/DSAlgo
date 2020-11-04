package org.coding.linkedList;// { Driver Code Starts
import java.util.*;
//class Node
//{
//    int data;
//    Node next;
//    Node(int d)
//    {
//        data = d;
//        next = null;
//    }
//}



public class NodeFromEnd
{
    Node head;
    Node tail;
    /* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }


    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node)
    {

        if (head == null)
        {
            head = node;
            tail = node;
        } else
        {
            tail.next = node;
            tail = node;
        }
    }

    /* Drier program to test above functions */
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        while(t>0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            NodeFromEnd llist = new NodeFromEnd();
            //int n=Integer.parseInt(br.readLine());
            int a1=sc.nextInt();
            Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            //System.out.println(llist.head.data);
            GfG g = new GfG();
            //System.out.println(k);
            System.out.println(g.getNthFromLast(llist.head,k));

            t--;
        }
    }
}



// } Driver Code Ends


/* Structure of node

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class GfG
{
    // Function to find the nth node from end in the linked list
    // head: head of the linked list
    // n: nth node from end to find
    int getNthFromLast(Node head, int n)
    {
       int count = n;
       int length =0;
       Node forwardPointer = head;
       Node currentPointer = head;
       Node lengthOfLinkedList = head;

       while(lengthOfLinkedList!=null)
       {
           length++;
           lengthOfLinkedList = lengthOfLinkedList.next;
       }

       if(n > length)
       {
           return -1;
       }
       while(count >0)
       {
           forwardPointer = forwardPointer.next;
           count--;
       }

       while(forwardPointer != null)
       {
           currentPointer = currentPointer.next;
           forwardPointer = forwardPointer.next;
       }

       return currentPointer.data;
    }
}
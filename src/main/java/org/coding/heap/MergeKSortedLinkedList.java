package org.coding.heap;// { Driver Code Starts
import java.util.*;


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



public class MergeKSortedLinkedList
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();

            Node []a = new Node[N];

            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();

                Node head = new Node(sc.nextInt());
                Node tail = head;

                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }

                a[i] = head;
            }

            Merge g = new Merge();

            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}// } Driver Code Ends


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


class Merge
{
    Node mergeKList(Node[]a,int N)
    {
        //Add your code here.

        Queue<Node> priorityQueue = new PriorityQueue<Node>((o1, o2) -> o2.data
        -o1.data);

        Node head=null;
        Node tail=null;


        for(int i =0; i < a.length; i++)
        {
            Node node =a[i];
            if(node!=null) {
                priorityQueue.add(node);

            }


        }


        while(priorityQueue.size() > 0)
        {
           Node node = priorityQueue.poll();

           if(node.next!=null) {
               priorityQueue.add(node.next);
           }

           if(head == null)
           {
               head  = node;
               tail = node;
           }
           else
           {
               tail.next = node;
           }
        }

       /* for(int i =0; i < a.length; i++)
        {
            Node node =a[i];
            if(node!=null) {

                newList.next = node;
            }


        }
       return newList;*/

        return head;
    }
}

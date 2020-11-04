//package org.coding.linkedList;
//
//// { Driver Code Starts
//// driver
//
//import java.util.Scanner;
//
////class Node {
////    int data;
////    Node next;
////
////    Node(int d) {
////        data = d;
////        next = null;
////    }
////}
//
//class AddTwoNumbersRepresentedByLinkedList {
//
//    static void printList(Node n) {
//        while (n != null) {
//            System.out.print(n.data + " ");
//            n = n.next;
//        }
//        System.out.println();
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//
//        while (T-- > 0) {
//
//            int n = sc.nextInt();
//            int val = sc.nextInt();
//
//            Node first = new Node(val);
//            Node tail = first;
//            for (int i = 0; i < n - 1; i++) {
//                val = sc.nextInt();
//                tail.next = new Node(val);
//                tail = tail.next;
//            }
//
//            int m = sc.nextInt();
//            val = sc.nextInt();
//
//            Node second = new Node(val);
//            tail = second;
//            for (int i = 0; i < m - 1; i++) {
//                val = sc.nextInt();
//                tail.next = new Node(val);
//                tail = tail.next;
//            }
//
//            Solution3 g = new Solution3();
//            Node res = g.addLists(first, second);
//            printList(res);
//        }
//    }
//}
//// } Driver Code Ends
//
//
///* node for linked list
//
//class Node {
//    int data;
//    Node next;
//
//    Node(int d) {
//        data = d;
//        next = null;
//    }
//}
//
//*/
//
//class Solution3 {
//    static Node addLists(Node first, Node second) {
//        // code here
//        // return head of sum list
//        Node firstNode = first;
//        Node secondNode = second;
//
//        StringBuilder stringBuilder1 = new StringBuilder();
//        while (firstNode != null) {
//            stringBuilder1.append(firstNode.data);
//            firstNode = firstNode.next;
//        }
//
//        StringBuilder stringBuilder2 = new StringBuilder();
//        while (secondNode != null) {
//            stringBuilder2.append(secondNode.data);
//            secondNode = secondNode.next;
//        }
//
//        Long total = Long.parseLong(stringBuilder1.toString()) + Long.parseLong(stringBuilder2.toString());
//
//        String digits = total.toString();
//
//        Node head;
//        Node currentNode = new Node(Integer.parseInt(String.valueOf(digits.charAt(0))));
//        head = currentNode;
//
//        for (int i = 1; i < digits.length(); i++) {
//            currentNode.next = new Node(Long.parseLong(String.valueOf(digits.charAt(i))));
//            currentNode = currentNode.next;
//        }
//     return  head;
//    }
//}

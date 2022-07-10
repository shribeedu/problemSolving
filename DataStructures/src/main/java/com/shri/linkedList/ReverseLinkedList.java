package com.shri.linkedList;

public class ReverseLinkedList {

   public static  void main(String args []){

       LinkedList list = new LinkedList();
       list.addNode(2);
       list.addNode(4);
       list.addNode(6);
       list.addNode(8);
       list.addNode(10);
       System.out.println("MY list \n");
       list.printList();
       System.out.println("\n Reversed list");
       list.reversLinkedList();
       list.printList();
   }

}

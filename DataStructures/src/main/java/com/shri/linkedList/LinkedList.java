package com.shri.linkedList;

public class LinkedList {

    Node head = null;

    public void addNode(int value){

        if(head == null){
            head = getNode(value);
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = getNode(value);
        }

    }

    public Node getNode(int val){
        Node node = new Node(val);
        return node;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.val + "-->");
            current = current.next;
        }
    }

    public void reversLinkedList(){

        Node current =head.next ,prev= head,temp=null;

        while(current != null){
            temp = current.next;
            current.next = prev;
            prev =current;
            current=temp;
        }

        head.next=null;
        head=prev;
    }

}

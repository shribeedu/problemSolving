package com.shri.linkedList;

public class RandomPointer {
	
	public static void main(String args[]) {
		
		Node head = null;
		Node copyNode = null;
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		
		//create base list
		head = node1;
		node1.next = node2;
		node2.next= node3;
		
		//link random pointer
		node1.rPointer=node3;
		node2.rPointer=node1;
		node3.rPointer=node2;
	
		System.out.println("*********************");
		System.out.println("****Original List****");
		Node temp = head;
		while(temp!=null) {
			System.out.print("  "+temp.val);
			temp = temp.next;
		}
		
		Node copyList = copyRandomPointerLst(head);
		temp = copyList;
		//print copied list
		System.out.println("*********************");
		System.out.println("**** Copied List ****\n");
		
		while(temp != null) {
			System.out.print(" "+temp.val);
			temp= temp.next;
		}
		
	}

	private static Node copyRandomPointerLst(Node head) {
		
		//insert copy node to the list
		Node tempNode = head;
		while(tempNode != null) {
			Node dummyNode = new Node(tempNode.val);
			dummyNode.next = tempNode.next;
			tempNode.next = dummyNode;
			tempNode = dummyNode.next;
		}
		System.out.println("\n********InterMediateList***********");
		tempNode = head;
		while(tempNode != null) {
			System.out.print("  "+tempNode.val);
			tempNode = tempNode.next;
		}
		
		//Adjust the rPointer
		tempNode = head;
		Node copyNode = head.next;
		while(tempNode != null) {
			Node dummyNode = tempNode.next;
			dummyNode.rPointer = tempNode.rPointer!=null ?tempNode.rPointer.next:null;
			tempNode.next = tempNode.next.next;
			dummyNode.next = tempNode.next;
			tempNode = tempNode.next;
		}
		return copyNode;
	}

}

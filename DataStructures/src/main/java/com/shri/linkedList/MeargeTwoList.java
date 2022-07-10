package com.shri.linkedList;


/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head1 = l1;
        ListNode head2 = l2;

        ListNode newList = new ListNode(0);
        ListNode newListHead=newList;

        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                newList.next = head1;
                head1 = head1.next;

            }else if(head1.val > head2.val){
                newList.next = head2;
                head2 = head2.next;
            }else if(head1.val == head2.val){

                //add the node from first list
                newList.next=head1;
                head1 = head1.next;
                newList=newList.next;

                newList.next=head2;
                head2 = head2.next;

            }
            newList=newList.next;

        }
        if(head1 != null){
            newList.next = head1;
        }

        if(head2 != null){
            newList.next = head2;
        }

        return newListHead.next;
    }


    public ListNode mergeTwoListRec(ListNode l1,ListNode l2){
        if(l1 ==null)
           return  l2;

        if(l2 == null)
            return l1;
        return new ListNode(-1);
    }

}

public class MeargeTwoList {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);
            ListNode ret = new Solution().mergeTwoLists(l1, l2);
            String out = listNodeToString(ret);
            System.out.print(out);
        }
    }
}

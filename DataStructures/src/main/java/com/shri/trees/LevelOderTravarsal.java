package com.shri.trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class LevelOderTravarsal {

    static LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();

    public  static  void main(String args []) {

        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.right.left = new TreeNode(6);
        tree1.right.right = new TreeNode(7);

        linkedList.add(tree1);
        levelOderTravarsal();
    }


    public static void levelOderTravarsal(){

        TreeNode node;
        System.out.println("Level Order travarsal");

        while(!linkedList.isEmpty()){
            node = linkedList.removeFirst();

            System.out.print(" "+node.val);
            if(node.left!=null){
                linkedList.add(node.left);
            }
            if(node.right !=null){
                linkedList.add(node.right);
            }
        }
    }
}

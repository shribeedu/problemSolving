package com.shri.trees;

class BinaryTreesIdentical{

  public static  void main(String args[]){

        TreeNode tree1;
        TreeNode tree2;

        System.out.println("Program to check weather two trees are identical or not");
        tree1 = new TreeNode(1);
        tree1.left=new TreeNode(2);
        tree1.right=new TreeNode(3);
        tree1.left.left= new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.right.left = new TreeNode(6);
        tree1.right.right = new TreeNode(7);


        tree2 = new TreeNode(1);
        tree2.left=new TreeNode(2);
        tree2.right=new TreeNode(3);
        tree2.left.left= new TreeNode(4);
        tree2.left.right = new TreeNode(5);
        tree2.right.left = new TreeNode(6);
        tree2.right.right = new TreeNode(10);


        if(isTreeIdentical(tree1,tree2)){
            System.out.println("Two trees are identical");
        }else {
            System.out.println("Two trees are not identical");
        }

        System.out.println("Height of the binary Tree is : "+heightOfBinaryTree(tree1));


  }

  public  static boolean isTreeIdentical(TreeNode node1,TreeNode node2){

       if(node1 == null && node2 == null){
           return  true;
       }

       if( (node1 !=null && node2 != null) && (node1.val == node2.val) && (isTreeIdentical(node1.left,node2.left) && isTreeIdentical(node1.right,node2.right)) ){
           return true;
       }else{
           return false;
       }
  }


  public static int heightOfBinaryTree(TreeNode node){
      int lHeight;
      int rHeight;
      if(node == null){
          return 0;
      }
      lHeight = heightOfBinaryTree(node.left);
      rHeight = heightOfBinaryTree(node.right);
      if(lHeight>rHeight){
          return  lHeight+1;
      }else
          return  rHeight+1;
  }

}
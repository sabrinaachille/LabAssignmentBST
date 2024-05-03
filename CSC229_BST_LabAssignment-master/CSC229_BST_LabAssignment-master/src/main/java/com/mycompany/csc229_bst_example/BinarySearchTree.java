package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        // ToDo 1: complete InOrder Traversal 
        if(root==null){
            return;
        }
        /*The root is visited in the middle 
        so the left side is checked first*/
        doInOrder(root.getLeft());
        System.out.println(root.getData());
        doInOrder(root.getRight());
    }
    
    public void preOrderTraversal() {
        doPreOrder(this.root);
        // ToDo 2: complete the pre-order travesal
    }
    
    private void doPreOrder(BstNode root) {
        if(root==null){
            return;
        }
        /*The root node is visted first and the values is printed 
        then the left side is checked and after the rigth*/
        System.out.println(root.getData());
        doPreOrder(root.getLeft());
        doPreOrder(root.getRight());
    }

    public Integer findHeight() {
        // ToDo 3: Find the height of a tree
        return getHeight(this.root);
    }
    
    private Integer getHeight(BstNode root){
        int leftHeight, rightHeight;
        //null root means the tree is empty
        if(root == null){
            return 0;
        }
        else{
            /*goes through the subtrees of root
            if node is not null the value of height increments*/
            leftHeight = getHeight(root.getLeft());
            rightHeight = getHeight(root.getRight());
            //the greater height is the tree overall height
            return Math.max(leftHeight, rightHeight);
        }
    }

    public int getDepth(BstNode node) {
        //ToDo 4: complete getDepth of a node
        return findDepth( root, node);
    }
    
    private int findDepth(BstNode root, BstNode node){
        int depth, leftDepth, rightDepth;
        //is the node is the root or tree is empty, return 0
        if(node==root || root==null){
            return 0;
        }
        else{
            //increment depth and goes through the subtrees 
            //of root till node is found
            leftDepth = findDepth(root.getLeft(), node);
            rightDepth = findDepth(root.getRight(), node);
            /*if the node is not found in either side the value 
            of height should be zero, if if was found then that depth 
            value will print*/
            return depth = Math.max(leftDepth, rightDepth);
        }
    }
    
   public void print() {
       System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
        // ToDo 5: complete the print of the BST
    }
   
   private void print(String space, BstNode root, Boolean isLeft){
       //empty tree returns nothing
       if(root == null){
           return;
       }
       //for each node add space
       space += " ";
       //similar to inOrder go through the tree from left to right
       //print the content of each node and go to new line for next level
       print(space, root.getLeft(), true);
       System.out.println("\n" + space + root.getData() + "\n");
       print(space, root.getRight(), false);
   }


}

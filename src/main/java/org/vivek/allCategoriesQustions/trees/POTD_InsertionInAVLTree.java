package org.vivek.allCategoriesQustions.trees;

//source : https://www.youtube.com/watch?v=a96JFhw5Ee4&ab_channel=CodingBlocks
public class POTD_InsertionInAVLTree {
    
    public  Node insertToAVL(Node node,int item)
    {
        if(node == null)return (new Node(item));
        if(item > node.data){
            node.right = insertToAVL(node.right,item);
        }else if(item < node.data){
            node.left = insertToAVL(node.left,item);
        }else{
            //duplicate keys are not allowed
            return node;
        }
        
        //after insertion node height will get updated
        node.height = Math.max(height(node.left),height(node.right))+1;
        
        int balancingFactor = balancingFactor(node);
        //Left-Left case
        if(balancingFactor > 1 && item < node.left.data){
            return rightRotate(node);
        }
        
        //Right-Right case
        if(balancingFactor < -1 && item > node.right.data){
            return leftRotate(node);
        }
        
        //Left-Right case
        if(balancingFactor > 1 && item > node.left.data){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        //Right-Left case
        if(balancingFactor < -1 && item < node.right.data){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
    }
    
    private int balancingFactor(Node node){
        if(node == null) return 0;
        return height(node.left) - height(node.right);
    }
    
    private int height(Node node){
        if(node == null) return 0;
        return node.height;
    }
    
    private Node rightRotate(Node c){
        Node b = c.left;
        Node T3 = b.right;
        //rotation
        b.right = c;
        c.left = T3;
        //height updation
        c.height = Math.max(height(c.left),height(c.right))+1;
        b.height = Math.max(height(b.left),height(b.right))+1;
        return b;
    }
    
    private Node leftRotate(Node c){
        Node b = c.right;
        Node T2 = b.left;
        //rotation
        b.left = c;
        c.right = T2;
        //height updation
        c.height = Math.max(height(c.left),height(c.right))+1;
        b.height = Math.max(height(b.left),height(b.right))+1;
        return b;
    }

    static class Node{
        int data;
        Node left;
        Node right;
        int height;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
            this.height = 1;
        }
    }
}

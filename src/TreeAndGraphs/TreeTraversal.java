package TreeAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

    public static void main(String[] args) {

        //Creating input tree
        String[] nodesVal = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
        Node root = new Node(nodesVal[0], null, null);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty() && i < nodesVal.length - 2){
            Node parent = queue.remove();
            Node left = new Node(nodesVal[i++],null, null);
            Node right = new Node(nodesVal[i++], null, null);

            parent.left = left;
            parent.right = right;

            queue.add(left);
            queue.add(right);
        }

        //Testing Inorder traversal
        System.out.println("Inorder traversal");
        inorderTraversal(root);

        System.out.println("\npre-order traversal");
        preOrderTraversal(root);

        System.out.println("\npost-order traversal");
        postOrderTraversal(root);
    }


    public static void inorderTraversal(Node node){
        if(node == null){
            return;
        }

        inorderTraversal(node.left);
        System.out.print(node.val + " ");
        inorderTraversal(node.right);
    }


    public static void preOrderTraversal(Node node){
        if(node == null){
            return;
        }

        System.out.print(node.val + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void postOrderTraversal(Node node){
        if(node == null){
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.val + " ");
    }

}


class Node{
    String val;
    Node left;
    Node right;

    Node(String val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
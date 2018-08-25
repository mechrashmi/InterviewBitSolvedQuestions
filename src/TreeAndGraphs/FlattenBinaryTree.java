package TreeAndGraphs;

/*
Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6


The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

Note that the left child of all nodes should be NULL
* */

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTree {
    public TreeNode1 flatten(TreeNode1 a) {
        if(a == null)
            return a;
        Queue<TreeNode1> queue = new LinkedList<>();
        preOrder(a, queue);
        TreeNode1 parent = queue.remove();

        while(!queue.isEmpty()){
            TreeNode1 child = queue.remove();
            parent.left = null;
            parent.right = child;
            parent = child;
        }

        return a;
    }

    public void preOrder(TreeNode1 A, Queue<TreeNode1> queue){
        if(A == null)
            return;

        queue.add(A);
        preOrder(A.left, queue);
        preOrder(A.right, queue);
    }
}

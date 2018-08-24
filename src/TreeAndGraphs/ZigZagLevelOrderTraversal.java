package TreeAndGraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrderWithTwoStack(TreeNode1 A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int k = 0;
        Queue<TreeNode1> queue = new LinkedList<TreeNode1>();
        queue.add(A);
        boolean left = true;
        int max_ele = 1;
        while(true){
            ArrayList<Integer> subList = new ArrayList<>();
            int ele_added = 0;
            while(!queue.isEmpty() && max_ele > 0){
                TreeNode1 node = queue.remove();
                subList.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                    ele_added++;
                }

                if(node.right != null){
                    queue.add(node.right);
                    ele_added++;
                }
                max_ele--;
            }

            max_ele = ele_added;
            if(!left){
                Collections.reverse(subList);
                left = true;
            }
            else{
                left = false;
            }

            res.add(subList);

            if(queue.isEmpty()){
                break;
            }
            k++;
        }

        return res;
    }
}

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1(int x) {
        val = x;
        left=null;
        right=null;
    }
}


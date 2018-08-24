package LinkedList;

//Incomplete
public class CheckIfaLLIsAPalindrome {


    //Incomplete
    public static boolean isPalindrome(Node root){
        if(root == null){
            return false;
        }

        if(root.next == null){
            return true;
        }

        return true;
    }

    public static Node reverse(Node root){
        if(root == null || root.next == null)
            return root;

        Node next = null;
        Node curr = root;
        Node prev= root.next;
        while(curr != null){
            curr.next = next;
            next = curr;
            curr = prev;
            if(prev != null)
                prev = prev.next;
        }

        return next;

    }

}

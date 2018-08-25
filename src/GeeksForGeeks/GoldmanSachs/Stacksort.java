package GeeksForGeeks.GoldmanSachs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Stacksort {
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>(Arrays.asList(new Integer[]{1, 5, 3}));
        Stack<Integer> s = new Stack<>();
        for(Integer ele : test){
            s.push(ele);
        }
        GfG.sort(s);
    }

}


class GfG{
    public static Stack<Integer> sort(Stack<Integer> s)
    {
        //add code here.
        Stack<Integer> tStack = new Stack<>();
        while(!s.isEmpty()){
            int temp = s.pop();
            while(!tStack.isEmpty() && tStack.peek() > temp){
                s.push(tStack.pop());
            }
            System.out.println(temp);
            tStack.push(temp);
        }

        return tStack;
    }
}

class LRUCache {
    int N;
    HashMap<Integer, Integer> LRU;
    HashMap<Integer, Integer> usage;

    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
        //Your code here
        this.N = N;
    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {
        //Your code here
        if(LRU.get(x) != null){
            usage.put(x, usage.get(x) + 1);
            return LRU.get(x);
        }

        return -1;
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        //Your code here
        if(LRU.size() == N){
            Integer leastUsed = findMinUsage();
            if(leastUsed == null) return;

            LRU.remove(leastUsed);
            usage.remove(leastUsed);
        }

        if(LRU.get(x) != null){
            LRU.put(x, y);
            usage.put(x, 0);
        }
    }

    public Integer findMinUsage(){
        if(usage.size() == 0){
            return null;
        }
        int e = Integer.MAX_VALUE;
        Integer in = null;
        for(Integer k : usage.keySet()){
            int val = usage.get(k);
            if( val < e){
                in = k;
            }
        }

        return in;
    }
}
package Recursion;

import java.util.Arrays;

public class CountWaysToReachTheNthStairUsingStep12or3 {

    public static void main(String[] args) {
        int n = 15;
        int[] mem = new int[ n + 1];
        Arrays.fill(mem, -1);
        int res = findCountStairs(n, mem);
        int expected = findStep(n);


        System.out.println(res + " : " + expected);
        assert(res != expected);
    }


    public static int findCountStairs(int n, int[] mem){
        if(n == 0)
            return 1;

        if(n < 0)
            return 0;

        if(mem[n] != -1)
            return mem[n];

        mem[n] = findCountStairs(n - 1, mem) + findCountStairs(n - 2, mem) + findCountStairs(n - 3, mem);

        return mem[n];

    }




    //copied from GeeksForGeeks to check my solution
    public static int findStep(int n)
    {
        if (n == 1 || n == 0)
            return 1;
        else if (n == 2)
            return 2;

        else
            return findStep(n - 3) +
                    findStep(n - 2) +
                    findStep(n - 1);
    }
}

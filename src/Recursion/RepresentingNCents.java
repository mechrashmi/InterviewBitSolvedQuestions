package Recursion;

import java.util.HashMap;

public class RepresentingNCents {

    public static void main(String[] args) {
        /*HashMap<Integer, Integer> mem = new HashMap<>();
        int[] cents = {1, 2, 3};
        System.out.println(count(cents, 2, 4));
        System.out.println(count(cents, 2, 10));*/
        //System.out.println(count(cents, 2, 4));

        HashMap<Integer, Integer> mem = new HashMap<>();
        int i, j;
        int arr[] = {1, 2, 3};
        int m = arr.length;
        System.out.println( count(arr, m, 100));
        System.out.println( count1(arr, m - 1, 100, mem));

    }

    public static int count1(int[] cents, int m, int totalCents, HashMap<Integer, Integer> mem){
        if(totalCents < 0 || m < 0)
            return 0;

        if(totalCents == 0)
            return 1;

        int sum = count(cents, m, totalCents - cents[m]) + count(cents, m - 1, totalCents);
        mem.put(totalCents, sum);
        return sum;

    }


    //GeeksForGeeks
    public static int count( int S[], int m, int n )
    {
        // table[i] will be storing the number of solutions for
        // value i. We need n+1 rows as the table is constructed
        // in bottom up manner using the base case (n = 0)
        int table[]=new int[n+1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for(int i=0; i<m; i++)
            for(int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];

        return table[n];
    }



}

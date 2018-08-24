package Recursion;

import java.util.Arrays;

public class KnapSack {

    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;
        int[] mem = new int[weight.length];
        Arrays.fill(mem, -1);
        System.out.println(findMax(0, W, 0, weight, value, mem));
    }

    public static int findMax(int w , int W, int i, int[] array_w, int[] array_v, int[] mem){
        if(i >= array_w.length)
            return 0;

        if((w + array_w[i]) > W ){
            return findMax(w, W, i + 1, array_w,array_v, mem);
        }

        int sum1 = array_v[i] + findMax( w + array_w[i], W, i + 1, array_w, array_v, mem);
        int sum2 = findMax(w, W, i + 1, array_w, array_v,mem);

        mem[i] = Math.max(sum1, sum2);
        return mem[i];
    }
}

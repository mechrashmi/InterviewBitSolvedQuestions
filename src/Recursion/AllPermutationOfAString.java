package Recursion;

import java.util.HashSet;

public class AllPermutationOfAString {
    public static void main(String[] args) {
        String input = "abca";
        //find(input, 0, input.length() - 1);
        HashSet<String> mem = new HashSet<>();

        findWithoutDup(input, 0, input.length() - 1, mem);
    }

    


    //This will print duplicates
    public static void find(String str, int l, int r){
        if(l > r){
            System.out.println(str);
            return;
        }

        for(int i = l; i <= r; i++){
            str = swap(str, l, i);
            find(str, l + 1, r);
            str = swap(str, l, i);
        }
    }

    public static void findWithoutDup(String str, int l, int r, HashSet<String> mem){
        if(l > r){
            if(mem.contains(str))
                return;

            mem.add(str);
            System.out.println(str);
            return;
        }

        for(int i = l; i <= r; i++){
            str = swap(str, l, i);
            findWithoutDup(str, l + 1, r, mem);
            str = swap(str, l, i);
        }
    }


    public static String swap(String str, int i, int j){
        StringBuilder builder = new StringBuilder(str);
        char temp = builder.charAt(i);
        builder.setCharAt(i, builder.charAt(j));
        builder.setCharAt(j, temp);
        return builder.toString();
    }
}

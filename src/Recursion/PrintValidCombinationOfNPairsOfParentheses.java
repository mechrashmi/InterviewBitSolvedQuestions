package Recursion;

import java.util.HashSet;

public class PrintValidCombinationOfNPairsOfParentheses {
    public static void main(String[] args) {
        HashSet<String> res = new HashSet<>();
        print(3, 3, "", res);

        for(String str : res){
            //System.out.println(str);
        }
    }


    public static void print(int open, int close, String str, HashSet<String> res){
        if(open == 0){
            StringBuilder builder = new StringBuilder(str);
            while(close > 0){
                builder.append(")");
                close--;
            }

            res.add(builder.toString());
            System.out.println(builder.toString());
            return;
        }

        //add both open and close parentheses: This not required: At each point either we need to add "(" or ")"
        //print(open - 1, close - 1, str + "(" + ")" , res);
        //add only open parentheses
        print(open - 1, close, str + "(", res);

        if(open < close){
            //add only open parentheses
            print(open, close - 1, str + ")", res);
        }
    }
}

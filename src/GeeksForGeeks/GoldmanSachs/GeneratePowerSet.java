package GeeksForGeeks.GoldmanSachs;

import java.util.ArrayList;
import java.util.Arrays;

public class GeneratePowerSet {
    public static void main(String[] args) {
        powerSet("abcd", 0, "");

        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(5));
        test(a);

        System.out.println("a : " + a.get(0));
    }


    public static void powerSet(String input, int index, String prefix){
        if(index == input.length()) {
            System.out.println("prefix = " + prefix);
            return;
        }


        powerSet(input, index + 1, prefix);
        powerSet(input, index + 1, prefix + input.charAt(index));

    }


    public static void test(ArrayList<Integer> a){
        a.set(0, 20);
    }
}

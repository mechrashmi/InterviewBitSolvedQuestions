package String;

public class ReverseAString {

    public static void main(String[] args) {
        String input = "abcdefghijklmnopqrst";

        StringBuilder expectedOutput = (new StringBuilder(input)).reverse();
        assert(!expectedOutput.toString().equals(reverse(input)));

        System.out.println(reverse(input));

    }


    public static String reverse(String input){
        StringBuilder stringBuilder = new StringBuilder(input);
        int i = 0, j = input.length() - 1;

        while(i <= j){
            char temp = stringBuilder.charAt(i);
            stringBuilder.setCharAt(i, stringBuilder.charAt(j));
            stringBuilder.setCharAt(j, temp);
            i++;
            j--;
        }


        return stringBuilder.toString();
    }
}

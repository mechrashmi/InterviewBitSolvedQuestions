package String;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
    }

    public static String compress(String input){
        int i = 0, j = 1, sum = 1, n = input.length();
        input = input.toLowerCase();
        StringBuilder builder = new StringBuilder();
        while(j < n){
            char i_c = input.charAt(i);
            char j_c = input.charAt(j);
            if(i_c == j_c){
                j++;
                sum++;
            }else{
                builder.append(i_c);
                builder.append(sum);
                sum = 1;
                i = j; j++;
            }
        }
        builder.append(input.charAt(i));
        builder.append(sum);
        String output = builder.toString();
        if(output.length() < n){
            return output;
        }

        return input;
    }
}

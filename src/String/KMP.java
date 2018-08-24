package String;

public class KMP {

    public static void main(String[] args) {
        String input = "aacecaaaa";
        System.out.println(findMinCharRequiredToMakePalindrome(input));
    }


    public static int findMinCharRequiredToMakePalindrome(String input){
        StringBuilder stringBuilder = new StringBuilder(input);
        String appendedString = stringBuilder.toString() + "$" + stringBuilder.reverse().toString();
        int[] lps = generateLPS(appendedString);
        int res = input.length() - lps[lps.length - 1];

        return res;
    }

    public static void testLPSFunc(String string){
        int[] res = generateLPS(string);

        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }



    public static int[] generateLPS(String input){
        int[] res = new int[input.length()];
        int i = 0, j = 1;
        if(input.length() > 0)
            res[0] = 0;

        int sum = 0;
        while(j < input.length()){
            if(input.charAt(i) == input.charAt(j)){
                res[j] = i + 1;
                i++;
                j++;
            }
            else{
                if(i == 0){
                    res[j] = i;
                    j++;
                }
                else{
                    i = res[i - 1];
                }
            }
        }

        return res;
    }
}

package Recursion;



//0 1 1 2 3 5 8 13
public class FibonacciSeries {

    public static void main(String[] args) {
        generateFibonacciSeries(20);
    }


    public static void generateFibonacciSeries(int n){
        if(n == 0)
            return;

        int prev = 0;
        int curr = 1;
        System.out.print(prev + " ");

        while(curr <= n){
            int temp = prev + curr;
            if(temp > n)
                break;
            System.out.print(temp +  " ");
            prev = curr;
            curr = temp;
        }
    }

}

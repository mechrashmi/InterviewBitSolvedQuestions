package Math;

public class FindSquareRootOfANumber {

    public static void main(String[] args) {
        System.out.println("sqrt(81) = " + sqrt(4));
        System.out.println("sqrt(81) = " + sqrt(81));
        System.out.println("sqrt(2401) = " + sqrt(2401));
        System.out.println("sqrt(6084) = " + sqrt(6084));
        System.out.println("sqrt(12769) = " + sqrt(12769));
    }

    //Using Binary search to find the square root of a number
    public static int sqrt(int num){
        int start = 0, end = num;
        int approxSqrt = 0;

        while(start <= end){
            int mid = (start + end) / 2;
            int mul = mid * mid;
            if(mul == num){
                approxSqrt = mid;
                break;
            }

            if(mul > num){
                end = mid - 1;
            }
            else{
                approxSqrt = mid;
                start = mid + 1;
            }

        }

        return approxSqrt;
    }
}

package GeeksForGeeks.GoldmanSachs;

public class MathFunctions {
    public static void main(String[] args) {
        int x = 3, y = 4;
        double val = power(x, y);
        assert(Math.pow(x, y) != val);
    }

    public static Double power(int x, int y){
        if(y  == 0)
            return 1.0;

        double val = x;

        for(int i = 2; i <= y; i++){
            val *= x;
        }

        return val;
    }
}

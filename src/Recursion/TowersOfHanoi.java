package Recursion;

public class TowersOfHanoi {

    public static void main(String[] args) {
        moveTower(4, 'A', 'C', 'B');
    }


    public static void moveTower(int n, Character from, Character to, Character aux){
        if(n == 1){
            System.out.println("Moved " + n + " from " + from + " to " + to);
            return;
        }

        moveTower(n - 1, from, aux, to);
        System.out.println("Moved " + n + " from " + from + " to " + to);
        moveTower(n - 1, aux, to, from);
    }
}

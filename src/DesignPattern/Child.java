package DesignPattern;

public class Child extends Parent {
    Child(){
        //super();
        System.out.println("Child()");
    }

    Child(int i){
      //this();
        System.out.println("Child(int)");
    }

    public void test(){
        super.test();
        System.out.println("Child test()");
    }


    public static void main(String[] args) {
        Child obj = new Child(10);
        ((Parent) obj).test();
    }
}



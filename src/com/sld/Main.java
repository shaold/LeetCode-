package com.sld;

public class Main {

    public static void main(String[] args) {
	// write your code here
    Integer i = 1;
    if (Integer.valueOf(0).equals(i)){
        System.out.println("true");
    }else{
        System.out.println("false");
    }

    }

    public static void a(){
        System.out.println("aaa");
        b();
    }

    public static void b(){
        System.out.println("bbb");
    }
}

class A {
    private int age = 1;
    String name = "A";

    public void say(){
        System.out.println("AAA");
    }
}

class B extends A{
    String name = "B";
    String sex = "男";

    @Override
    public void say(){
        System.out.println("BBB");
    }
}

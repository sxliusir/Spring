package com.sxliusir.spring.lazyInit;

public class C {
    private String name;
    private A a;

    public C() {
        super();
        System.out.println("C Init...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}

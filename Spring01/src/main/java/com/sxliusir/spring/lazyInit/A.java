package com.sxliusir.spring.lazyInit;

public class A {
    private String name;

    private B b;

    public A() {
        super();
        System.out.println("A Init...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}

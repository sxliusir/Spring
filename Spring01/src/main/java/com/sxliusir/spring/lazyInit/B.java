package com.sxliusir.spring.lazyInit;

public class B {
    private String name;
    private C c;

    public B() {
        super();
        System.out.println("B Init...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }
}

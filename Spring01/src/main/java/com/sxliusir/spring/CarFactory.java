package com.sxliusir.spring;

public class CarFactory {
    public CarFactory() {
        super();
        System.out.println("CarFactory");
    }

    public static Car getCar(String name) throws Exception {
        if(name.equals("audi")) {
            return new Audi();
        } else if(name.equals("bmw")) {
            return new Bmw();
        } else {
            throw new Exception("暂无");
        }
    }
}

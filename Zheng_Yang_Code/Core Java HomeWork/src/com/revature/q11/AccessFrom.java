package com.revature.q11;

import com.revature.q11.AnotherPackages.Variables;

public class AccessFrom {

    public AccessFrom() { }

    public static void main(String[] args) {
        Variables numbers = new Variables();

        System.out.println("Float one: "+ numbers.floatOne);
        System.out.println("Float Two: "+ numbers.floatTwo);
    }
}

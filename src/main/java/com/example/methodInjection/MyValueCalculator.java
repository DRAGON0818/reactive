package com.example.methodInjection;

/**
 * @author whoami
 */
public class MyValueCalculator {
    public String computeValue(String input){
        System.out.println("MyValueCalculator : " + input);
        return "MyCalculator : "+ input;
    }
}

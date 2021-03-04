package com.example.methodInjection;

/**
 * @author whoami
 */
public class WalletService {
    public WalletService() {
        System.out.println("WalletService");
    }

    public void run(){
        System.out.println("this = : " + this);
    }
}

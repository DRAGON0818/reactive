package com.example.methodInjection;

/**
 * @author whoami
 */
public abstract class UserService {
    public abstract WalletService createWalletService();

    public UserService() {
        System.out.println("UserService 正在实例化");
    }

    public void login(String userName, String password) {
        createWalletService().run();
        System.out.println(userName+ " 正在登陆");
    }

}

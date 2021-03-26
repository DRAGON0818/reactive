package com.example.factory;

/**
 * 工厂类的实现方式
 * @author whoami
 */
public class ClientService {
    private static ClientService clientService = new ClientService();
    private ClientService(){};

    public static ClientService createInstance(){
        return clientService;
    }
}

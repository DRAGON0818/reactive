package com.example.service;

/**
 * @author whoami
 * Instantiation with a Static Factory Method
 */
public class ClientService {
    private static ClientService clientService = new ClientService();
    private ClientService(){}

    public static ClientService createClientService(){
        return clientService;
    }
}

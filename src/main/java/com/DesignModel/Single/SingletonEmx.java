package com.DesignModel.Single;

/**
 * 所有线程安全的单例模式写法
 * @author whoami
 */
public class SingletonEmx {
    private static volatile SingletonEmx instance = null;

    private SingletonEmx(){
    }

    private static synchronized SingletonEmx getInstance(){
        if (instance == null) {
            instance = new SingletonEmx();
        }
            return instance;
    }

}

package com.example.Bean;

import org.springframework.beans.factory.DisposableBean;

/**
 * @author whoami
 */
public class BasicDataSource implements DisposableBean {
    private String driverClassName;
    private String username;
    private String password;
    private String url;

    public BasicDataSource() {
    }

    public BasicDataSource(String driverClassName, String username, String password, String url) {
        this.driverClassName = driverClassName;
        this.username = username;
        this.password = password;
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void close(){
        System.out.println("My BasicDataSource is closed!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("My BasicDataSource is closed by implements!");
    }
}

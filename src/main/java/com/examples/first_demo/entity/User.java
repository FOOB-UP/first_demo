package com.examples.first_demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 更改对应的表
 */
//@TableName("")
public class User {

    public String name;
    public String password;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

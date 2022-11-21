package com.examples.first_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@TableName("orders")
public class order {

    @TableId(type = IdType.AUTO)
    public int id;

    public int userId;
    public String orderName;
    public Date orderTime;
    @TableField(javaType = false)
    public List<User> user;


    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }


    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderName='" + orderName + '\'' +
                ", orderTime=" + orderTime +
                ", user=" + user +
                '}';
    }
}

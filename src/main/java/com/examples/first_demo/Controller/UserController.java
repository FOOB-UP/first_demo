package com.examples.first_demo.Controller;

import com.examples.first_demo.entity.User;
import com.examples.first_demo.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation("获取用户")
    @GetMapping("/user")
    public String query(){
        List<User> list = userMapper.find();
        return "成功了"+list.toString();
    }

    @ApiOperation("新增用户")
    @PostMapping("/user")
    public User hsx(@RequestBody User user) {
        System.out.println("name" + user.name);
        System.out.println("password" + user.password);
        return user;
    }

    @ApiOperation("更新用户")
    @PutMapping("/user")
    public User gets(User user){
        System.out.println(user);
        return user;
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/user/{id}")
    public String getname(@PathVariable String id){
        System.out.println(id);
        return "username： "+id;
    }

}
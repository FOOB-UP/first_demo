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
        List<User> list = userMapper.selectList(null);
        return "成功了"+list.toString();
    }

    @ApiOperation("新增用户")
    @PostMapping("/user")
    public String add(@RequestBody User user) {
        int i = userMapper.insert(user);
        return "新增用户成功";
    }

    @ApiOperation("更新用户")
    @PutMapping("/user")
    public String gets(User user){
        int i = userMapper.updateById(user);
        return "更新成功";
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/user/{id}")
    public String getname(@PathVariable String id){
        int i =userMapper.deleteById(id);
        return "删除成功： "+id;
    }
}
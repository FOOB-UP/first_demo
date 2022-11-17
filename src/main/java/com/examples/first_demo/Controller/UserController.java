package com.examples.first_demo.Controller;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.examples.first_demo.entity.User;
import com.examples.first_demo.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation("根据用户名获取用户")
    @GetMapping("/user/{name}")
    public String query(String name){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper();
        userQueryWrapper.eq("name",name);
        List<User> list = userMapper.selectList(userQueryWrapper);
        return list.toString();
    }

    @ApiOperation("获取全部用户并将其分组")
    @GetMapping("/FildAll")
    public IPage FindAll(){
        Page<User> userPage =new Page<>(0,2);
        IPage iPage = userMapper.selectPage(userPage,null);
        return iPage;
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

    @ApiOperation("查询用户之下的订单")
    @GetMapping("/user_order")
    public List<User> getUserOrder(){
        System.out.println(userMapper.finds().toString());
        return userMapper.finds();
    }


    @ApiOperation("根据id查询用户")
    @GetMapping("/userfind/{id}")
    public List<User> getUserFind(int id){
        return userMapper.findbyid(id);
    }

}
package com.examples.first_demo.Controller;

import com.examples.first_demo.Dao.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hell(){
        return "你好安";
    }


    @RequestMapping("/uses")
    public String hell(String name){
        System.out.println(name);
        return "成功了"+name;
    }

    @RequestMapping(value = "/lo",method = RequestMethod.POST)
    public User hsx(@RequestBody User user){
        System.out.println("name"+user.name);
        System.out.println("password"+user.password);
        return user;
    }

    @RequestMapping(value = "/mast",method = RequestMethod.GET)
    public User gets(User user){
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "/ioo",method = RequestMethod.GET)
    public String getname(String name){
        System.out.println(name);
        return "username： "+name;
    }






}
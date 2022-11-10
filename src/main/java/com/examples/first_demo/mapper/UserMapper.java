package com.examples.first_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.examples.first_demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

//    @Select("select * from user limit 10")
//    public List<User> find();
//
//    @Insert("insert into user(name,password) values(#{name},#{password})")
//    public int add(User user);
//
//    public int update(User user);
//
//    public int romve(User user)
}

package com.examples.first_demo.mapper;

import com.examples.first_demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user limit 10")
    public List<User> find();



}

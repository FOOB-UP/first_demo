package com.examples.first_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.examples.first_demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.core.annotation.Order;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

//    @Select("select * from user limit 10")
//    public List<User> find();
//
//    @Insert("insert into user(name,password) values(#{name},#{password})")
//    public int add(User user);
//
      @Select("select * from user")
      @Results(
              {
                      @Result(column = "id",property = "id"),
                      @Result(column = "name",property = "name"),
                      @Result(column = "password",property = "password"),
                      @Result(column = "id",property = "orders",javaType = List.class,
                              many = @Many(select = "com.examples.first_demo.mapper.OrderMapper.findByid")
                      )

              }
      )
      List<User> finds();

      @Select("select * from user where id = #{id} ")
      List<User> findbyid(int id);
//
//    public int romve(User user)
}

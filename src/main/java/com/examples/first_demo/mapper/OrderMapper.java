package com.examples.first_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.examples.first_demo.entity.order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<order> {

    @Select("select * from orders where user_id = #{id}")
    List<order> findByid(int id);

    @Select("select * from orders")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "order_name", property = "orderName"),
            @Result(column = "order_time", property = "orderTime"),
            @Result(column = "user_id", property = "user", javaType = List.class,
                    one = @One(select = "com.examples.first_demo.mapper.UserMapper.findbyid")
            )}
    )
    List<order> findOrderUser();
}

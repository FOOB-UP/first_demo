package com.examples.first_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.examples.first_demo.entity.order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<order> {

    @Select("select * from orders where user_id = #{id}")
    List<order> findByid(int id);
}

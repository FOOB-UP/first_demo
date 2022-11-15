package com.examples.first_demo.Controller;

import com.examples.first_demo.entity.order;
import com.examples.first_demo.mapper.OrderMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    public OrderMapper orderMapper;

    @ApiOperation("查询订单")
    @GetMapping("/orders/{id}")
    List<order> finds(@PathVariable int id){
        List<order> orders = orderMapper.findByid(id);
        System.out.println(orders.toString());
        return orderMapper.findByid(id);
    }

}

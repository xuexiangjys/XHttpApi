package com.xuexiang.xhttpapi.mapper;

import com.xuexiang.xhttpapi.model.Order;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    Order selectByPrimaryKey(Integer orderId);

    List<Order> selectAll();

    List<Order> queryOrder(Integer userId);

    int updateByPrimaryKey(Order record);
}
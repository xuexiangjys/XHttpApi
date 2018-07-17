package com.xuexiang.xhttpapi.mapper;

import com.xuexiang.xhttpapi.model.OrderInfo;
import java.util.List;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer orderId);

    List<OrderInfo> selectAll();

    List<OrderInfo> queryOrder(Integer userId);

    int updateByPrimaryKey(OrderInfo record);
}
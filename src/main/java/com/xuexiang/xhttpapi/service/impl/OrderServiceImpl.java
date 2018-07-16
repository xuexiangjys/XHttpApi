package com.xuexiang.xhttpapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.xuexiang.xhttpapi.mapper.OrderMapper;
import com.xuexiang.xhttpapi.model.Order;
import com.xuexiang.xhttpapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuexiang
 * @since 2018/7/16 下午12:06
 */
@Service(value = "orderService")
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;//这里会报错，但是并不会影响

    @Override
    public boolean addOrder(Order order) {
        return orderMapper.insert(order) > 0;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        return orderMapper.deleteByPrimaryKey(orderId) > 0;
    }

    @Override
    public boolean updateOrder(Order record) {
        return orderMapper.updateByPrimaryKey(record) > 0;
    }

    @Override
    public List<Order> findAllOrder(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return orderMapper.selectAll();
    }

    @Override
    public List<Order> findAllOrder() {
        return orderMapper.selectAll();
    }

    @Override
    public List<Order> queryOrder(int userId) {
        return orderMapper.queryOrder(userId);
    }
}

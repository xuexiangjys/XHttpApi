package com.xuexiang.xhttpapi.service;

import com.xuexiang.xhttpapi.model.OrderInfo;

import java.util.List;

/**
 * 订单服务
 *
 * @author xuexiang
 * @since 2018/7/16 上午11:59
 */
public interface OrderService {

    /**
     * 下单
     *
     * @param order
     * @return
     */
    boolean addOrder(OrderInfo order);

    /**
     * 删除订单
     *
     * @param orderId
     * @return
     */
    boolean deleteOrder(int orderId);

    /**
     * 更新订单
     *
     * @param record
     * @return
     */
    boolean updateOrder(OrderInfo record);

    /**
     * 分页查询所有订单
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<OrderInfo> findAllOrder(int pageNum, int pageSize);

    /**
     * 查询所有订单
     *
     * @return
     */
    List<OrderInfo> findAllOrder();

    /**
     * 查询用户的所有订单
     * @param userId
     * @return
     */
    List<OrderInfo> queryOrder(int userId);

}

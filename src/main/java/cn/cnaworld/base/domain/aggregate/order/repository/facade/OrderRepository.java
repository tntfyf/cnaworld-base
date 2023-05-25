package cn.cnaworld.base.domain.aggregate.order.repository.facade;

import cn.cnaworld.base.domain.aggregate.order.model.root.Order;

/**
 * @author Lucifer
 * @date 2023/5/25
 * @since
 */

public interface OrderRepository{

    /**
     * 保存订单
     * @param order 订单
     */
   void saveOrder(Order order);

    /**
     * 查询订单
     * @param orderId 订单Id
     * @return 订单信息
     */
    Order queryOrderById(Long orderId);

}

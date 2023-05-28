package cn.cnaworld.base.domain.order.event;

import cn.cnaworld.base.domain.order.model.root.Order;
import cn.cnaworld.base.infrastructure.bus.DomainEvent;

/**
 * @author Administrator
 * @date 2023/5/25
 * @since
 */
public class OrderEvent extends DomainEvent {

    private Long orderId;

    public OrderEvent(Order order) {
        super("Order.OrderEvent");
        orderId = order.getOrderId();
    }

}

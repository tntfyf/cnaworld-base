package cn.cnaworld.base.domain.event.order;

import cn.cnaworld.base.domain.event.order.vo.OrderEventVo;
import cn.cnaworld.base.infrastructure.component.bus.DomainEvent;

/**
 * @author Administrator
 * @date 2023/5/25
 * @since
 */
public class OrderEvent extends DomainEvent {

    private Long orderId;

    public OrderEvent(OrderEventVo orderEventVo) {
        super(orderEventVo);
        orderId = orderEventVo.getOrderId();
    }

}

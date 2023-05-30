package cn.cnaworld.base.domain.order.event;

import cn.cnaworld.base.domain.order.event.vo.OrderEventVo;
import cn.cnaworld.base.domain.order.model.root.Order;
import cn.cnaworld.base.infrastructure.component.bus.DomainEvent;
import cn.cnaworld.base.infrastructure.utils.BeanCopierUtil;
import net.bytebuddy.implementation.bind.annotation.This;

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

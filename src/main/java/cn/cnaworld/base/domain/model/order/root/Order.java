package cn.cnaworld.base.domain.model.order.root;

import cn.cnaworld.base.domain.event.order.OrderEvent;
import cn.cnaworld.base.domain.event.order.vo.OrderEventVo;
import cn.cnaworld.base.domain.model.order.entity.Goods;
import cn.cnaworld.base.domain.model.order.vo.OrderStatus;
import cn.cnaworld.base.domain.model.order.repository.OrderRepository;
import cn.cnaworld.base.infrastructure.repository.order.orm.po.OrdersPo;
import cn.cnaworld.base.domain.model.order.service.OrderDomainService;
import cn.cnaworld.base.infrastructure.component.bus.DomainEventBus;
import cn.cnaworld.base.infrastructure.utils.BeanCopierUtil;
import cn.cnaworld.base.infrastructure.utils.SpringBeanUtil;
import lombok.*;

/**
 * 订单聚合根
 * @author Lucifer
 * @date 2023/5/25
 * @since 1.0.1.1
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order extends OrdersPo  {
    //订单领域仓储
    private OrderRepository orderRepository = SpringBeanUtil.getBean(OrderRepository.class);

    private DomainEventBus eventBus = SpringBeanUtil.getBean(DomainEventBus.class);

    private Goods goods;

    private OrderStatus orderStatus;

    /**
     * 领域方法查询订单领域信息
     * @author Administrator
     * @date 2023/5/28
     */
    public Order getOrderInfo(){
        //调用订单领域仓库查询
        return orderRepository.getOrderById(this.getOrderId());
    }

    /**
     * 下单成功通知商品领域下单成功事件
     * @date 2023/5/29
     */
    public void success() {
        this.setOrderStatus(OrderStatus.success);
        OrderEventVo orderEventVo = BeanCopierUtil.copy(this, OrderEventVo.class);
        eventBus.post(new OrderEvent(orderEventVo));
    }

}

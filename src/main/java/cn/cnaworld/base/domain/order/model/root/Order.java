package cn.cnaworld.base.domain.order.model.root;

import cn.cnaworld.base.domain.order.event.OrderEvent;
import cn.cnaworld.base.domain.order.model.entity.Goods;
import cn.cnaworld.base.domain.order.model.vo.OrderType;
import cn.cnaworld.base.domain.order.repository.facade.OrderRepository;
import cn.cnaworld.base.domain.order.repository.orm.po.OrdersPo;
import cn.cnaworld.base.domain.order.service.OrderDomainService;
import cn.cnaworld.base.infrastructure.component.bus.DomainEventBus;
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
public class Order extends OrdersPo {
    //订单领域仓储
    private OrderRepository orderRepository = SpringBeanUtil.getBean(OrderRepository.class);

    //订单领域服务
    private OrderDomainService orderDomainService =  SpringBeanUtil.getBean(OrderDomainService.class);

    private DomainEventBus eventBus = SpringBeanUtil.getBean(DomainEventBus.class);;

    private Goods goods;

    private OrderType orderType;

    /**
     * 领域方法查询订单领域信息
     * @author Administrator
     * @date 2023/5/28
     */
    public Order getOrderInfo(){
        //调用订单领域仓库查询
        return orderRepository.queryOrderById(this.getOrderId());
    }

    /**
     * 调用订单领域服务处理领域中聚合根值对象实体之间的业务逻辑
     * @author Administrator
     * @date 2023/5/28
     */
    public void domainLogicalProcessing(){
        //调用订单领域服务处理领域中聚合根值对象实体之间的业务逻辑
        orderDomainService.domainLogicalProcessing();
    }

    /**
     * 下单成功通知商品领域下单成功事件
     * @date 2023/5/29
     */
    public void success() {
        eventBus.post(new OrderEvent(this));
    }

}

package cn.cnaworld.base.domain.order.model.root;

import cn.cnaworld.base.domain.order.event.OrderEvent;
import cn.cnaworld.base.domain.order.event.vo.OrderEventVo;
import cn.cnaworld.base.domain.order.model.entity.Goods;
import cn.cnaworld.base.domain.order.model.vo.OrderStatus;
import cn.cnaworld.base.domain.order.service.OrderDomainService;
import cn.cnaworld.base.infrastructure.component.bus.DomainEventBus;
import cn.cnaworld.base.infrastructure.repository.order.orm.po.OrdersPo;
import cn.cnaworld.base.infrastructure.utils.BeanCopierUtil;
import cn.cnaworld.base.infrastructure.utils.SpringBeanUtil;
import cn.cnaworld.framework.infrastructure.exception.BusinessException;
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
    //订单领域服务
    private OrderDomainService orderDomainService =  SpringBeanUtil.getBean(OrderDomainService.class);

    private DomainEventBus eventBus = SpringBeanUtil.getBean(DomainEventBus.class);

    private Goods goods;

    private OrderStatus orderStatus;

    /**
     * 调用订单领域服务处理领域中聚合根值对象实体之间的业务逻辑
     * @author Administrator
     * @date 2023/5/28
     */
    public void checkValid(){
        if (orderStatus == null || orderStatus.equals(OrderStatus.cancel)){
            throw new BusinessException("订单已经失效");
        }
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

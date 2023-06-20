package cn.cnaworld.base.domain.product.event;

import cn.cnaworld.base.domain.order.event.OrderEvent;
import cn.cnaworld.base.domain.order.event.vo.OrderEventVo;
import cn.cnaworld.base.domain.order.model.vo.OrderStatus;
import cn.cnaworld.base.infrastructure.component.bus.DomainEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date 2023/5/28
 * @since
 */
@Component
public class ProductListener implements ApplicationListener<DomainEvent> {

    /**
     * @param event
     */
    @Override
    public void onApplicationEvent(@NotNull DomainEvent event) {
        //判断是否是订单领域事件
        if (event instanceof OrderEvent) {
            OrderEventVo orderEventVo = (OrderEventVo) event.getSource();
            //判断订单领域事件是否是成功事件
            if(OrderStatus.success.equals(orderEventVo.getOrderStatus())){
                System.out.println("处理订单事件，加减库存:"+event+"orderEventVo:"+orderEventVo);
            }
        }
    }
}

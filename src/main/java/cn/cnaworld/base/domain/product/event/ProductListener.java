package cn.cnaworld.base.domain.product.event;

import cn.cnaworld.base.domain.order.event.OrderEvent;
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
        if (event instanceof OrderEvent) {
            System.out.println("处理订单事件，加减库存"+event);
        }
    }
}

package cn.cnaworld.base.domain.order.model.root;

import cn.cnaworld.base.domain.order.model.entity.Goods;
import cn.cnaworld.base.domain.order.model.vo.OrderType;
import cn.cnaworld.base.domain.order.repository.facade.OrderRepository;
import cn.cnaworld.base.domain.order.repository.orm.po.OrdersPo;
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

    private OrderRepository orderRepository = SpringBeanUtil.getBean(OrderRepository.class);

    private Goods goods;

    private OrderType orderType;

    public Order getOrderInfo(){
        return orderRepository.queryOrderById(this.getOrderId());
    }

}

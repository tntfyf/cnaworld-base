package cn.cnaworld.base.domain.order.model.root;

import cn.cnaworld.base.domain.order.model.entity.Goods;
import cn.cnaworld.base.domain.order.repository.facade.OrderRepository;
import cn.cnaworld.base.domain.order.repository.orm.po.OrderPo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订单聚合根
 * @author Lucifer
 * @date 2023/5/25
 * @since 1.0.1.1
 */
@Getter
@Setter
@ToString
@Component
public class Order extends OrderPo {

    @Autowired
    private OrderRepository orderRepository;

    private Goods goods;

    public Order getOrderInfo(Long id){
        return orderRepository.queryOrderById(id);
    }



}

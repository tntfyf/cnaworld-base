package cn.cnaworld.base.domain.order.event.vo;

import cn.cnaworld.base.domain.order.event.OrderEvent;
import cn.cnaworld.base.domain.order.model.entity.Goods;
import cn.cnaworld.base.domain.order.model.vo.OrderStatus;
import cn.cnaworld.base.domain.order.repository.facade.OrderRepository;
import cn.cnaworld.base.domain.order.repository.orm.po.OrdersPo;
import cn.cnaworld.base.domain.order.service.OrderDomainService;
import cn.cnaworld.base.infrastructure.component.bus.DomainEventBus;
import cn.cnaworld.base.infrastructure.utils.SpringBeanUtil;
import lombok.*;

import java.io.Serializable;

/**
 * 订单聚合根
 * @author Lucifer
 * @date 2023/5/25
 * @since 1.0.1.1
 */
@Getter
@Setter
@ToString
public class OrderEventVo extends OrdersPo implements Serializable {

    private Goods goods;

    private OrderStatus orderStatus;

}

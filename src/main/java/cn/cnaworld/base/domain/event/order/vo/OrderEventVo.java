package cn.cnaworld.base.domain.event.order.vo;

import cn.cnaworld.base.domain.model.order.entity.Goods;
import cn.cnaworld.base.domain.model.order.vo.OrderStatus;
import cn.cnaworld.base.infrastructure.repository.order.orm.po.OrdersPo;
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

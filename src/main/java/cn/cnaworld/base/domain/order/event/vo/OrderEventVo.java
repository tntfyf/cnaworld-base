package cn.cnaworld.base.domain.order.event.vo;

import cn.cnaworld.base.domain.order.model.entity.Goods;
import cn.cnaworld.base.domain.order.model.vo.OrderStatus;
import cn.cnaworld.base.infrastructure.repository.order.orm.po.OrdersPo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

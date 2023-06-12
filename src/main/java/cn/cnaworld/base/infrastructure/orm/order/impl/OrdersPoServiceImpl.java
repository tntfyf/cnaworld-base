package cn.cnaworld.base.infrastructure.orm.order.impl;

import cn.cnaworld.base.infrastructure.orm.order.IOrdersPoService;
import cn.cnaworld.base.infrastructure.orm.order.mapper.OrdersPoMapper;
import cn.cnaworld.base.infrastructure.orm.order.po.OrdersPo;
import cn.cnaworld.framework.infrastructure.component.mybatisplus.baseclass.service.impl.CnaWorldBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lucifer
 * @since 2023-05-26
 */
@Service
public class OrdersPoServiceImpl extends CnaWorldBaseServiceImpl<OrdersPoMapper, OrdersPo> implements IOrdersPoService {

}

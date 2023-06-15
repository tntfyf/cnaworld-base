package cn.cnaworld.base.infrastructure.repository.order.orm.impl;

import cn.cnaworld.base.infrastructure.repository.order.orm.IOrdersPoService;
import cn.cnaworld.base.infrastructure.repository.order.orm.mapper.OrdersPoMapper;
import cn.cnaworld.base.infrastructure.repository.order.orm.po.OrdersPo;
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

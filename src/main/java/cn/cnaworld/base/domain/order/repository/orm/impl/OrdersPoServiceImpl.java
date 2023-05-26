package cn.cnaworld.base.domain.order.repository.orm.impl;

import cn.cnaworld.base.domain.order.repository.orm.IOrdersPoService;
import cn.cnaworld.base.domain.order.repository.orm.mapper.OrdersPoMapper;
import cn.cnaworld.base.domain.order.repository.orm.po.OrdersPo;
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

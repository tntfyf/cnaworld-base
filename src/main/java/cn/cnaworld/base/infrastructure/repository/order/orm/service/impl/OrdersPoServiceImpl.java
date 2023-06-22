package cn.cnaworld.base.infrastructure.repository.order.orm.service.impl;

import cn.cnaworld.base.infrastructure.repository.order.orm.service.IOrdersPoService;
import cn.cnaworld.base.infrastructure.repository.order.orm.mapper.OrdersPoMapper;
import cn.cnaworld.base.infrastructure.repository.order.orm.po.OrdersPo;
import cn.cnaworld.framework.infrastructure.component.mybatisplus.baseclass.service.impl.CnaWorldBaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lucifer
 * @since 2023-05-26
 */
@Service
@Transactional
public class OrdersPoServiceImpl extends CnaWorldBaseServiceImpl<OrdersPoMapper, OrdersPo> implements IOrdersPoService {

}

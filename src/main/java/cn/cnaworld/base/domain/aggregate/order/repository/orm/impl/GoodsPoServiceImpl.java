package cn.cnaworld.base.domain.aggregate.order.repository.orm.impl;

import cn.cnaworld.base.domain.aggregate.order.repository.orm.IGoodsPoService;
import cn.cnaworld.base.domain.aggregate.order.repository.orm.mapper.GoodsPoMapper;
import cn.cnaworld.base.domain.aggregate.order.repository.orm.po.GoodsPo;
import cn.cnaworld.framework.infrastructure.component.mybatisplus.baseclass.service.impl.CnaWorldBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lucifer
 * @since 2023-05-25
 */
@Service
public class GoodsPoServiceImpl extends CnaWorldBaseServiceImpl<GoodsPoMapper, GoodsPo> implements IGoodsPoService {

}

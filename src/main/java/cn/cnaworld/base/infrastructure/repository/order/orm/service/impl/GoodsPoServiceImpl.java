package cn.cnaworld.base.infrastructure.repository.order.orm.service.impl;

import cn.cnaworld.base.infrastructure.repository.order.orm.mapper.GoodsPoMapper;
import cn.cnaworld.base.infrastructure.repository.order.orm.po.GoodsPo;
import cn.cnaworld.base.infrastructure.repository.order.orm.service.IGoodsPoService;
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

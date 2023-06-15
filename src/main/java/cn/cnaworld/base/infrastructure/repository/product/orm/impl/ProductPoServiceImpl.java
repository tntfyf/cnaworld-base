package cn.cnaworld.base.infrastructure.repository.product.orm.impl;

import cn.cnaworld.base.infrastructure.repository.product.orm.IProductPoService;
import cn.cnaworld.base.infrastructure.repository.product.orm.mapper.ProductPoMapper;
import cn.cnaworld.base.infrastructure.repository.product.orm.po.ProductPo;
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
public class ProductPoServiceImpl extends CnaWorldBaseServiceImpl<ProductPoMapper, ProductPo> implements IProductPoService {

}

package cn.cnaworld.base.infrastructure.orm.product.impl;


import cn.cnaworld.base.infrastructure.orm.product.IProductPoService;
import cn.cnaworld.base.infrastructure.orm.product.mapper.ProductPoMapper;
import cn.cnaworld.base.infrastructure.orm.product.po.ProductPo;
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

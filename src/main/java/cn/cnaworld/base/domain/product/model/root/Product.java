package cn.cnaworld.base.domain.product.model.root;

import cn.cnaworld.base.domain.product.repository.facade.ProductRepository;
import cn.cnaworld.base.infrastructure.orm.product.po.ProductPo;
import cn.cnaworld.base.infrastructure.utils.SpringBeanUtil;

/**
 * @author Lucifer
 * @date 2023/5/26
 * @since
 */
public class Product extends ProductPo {

    private ProductRepository productRepository = SpringBeanUtil.getBean(ProductRepository.class);

    public Product getProductInfo(){
        return   productRepository.queryProductById(this.getProductId());
    }

}

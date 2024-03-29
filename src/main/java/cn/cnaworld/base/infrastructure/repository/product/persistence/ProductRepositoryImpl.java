package cn.cnaworld.base.infrastructure.repository.product.persistence;

import cn.cnaworld.base.domain.product.model.root.Product;
import cn.cnaworld.base.infrastructure.repository.product.facade.ProductRepository;
import cn.cnaworld.base.infrastructure.repository.product.orm.po.ProductPo;
import cn.cnaworld.base.infrastructure.repository.product.orm.service.IProductPoService;
import cn.cnaworld.framework.infrastructure.utils.bean.CnaBeanCopierUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Lucifer
 * @date 2023/5/25
 * @since 1.0.1.1
 */
@Service
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private IProductPoService iProductPoService;

    /**
     * 保存聚合根
     *
     * @param product 商品
     */
    @Override
    public void saveProduct(Product product) {
        if(product!=null){
            iProductPoService.save(product);
        }
    }

    /**
     * 查询商品
     *
     * @param productId 商品Id
     */
    @Override
    public Product getProductById(Long productId) {
        ProductPo productPo = iProductPoService.getById(productId);
        return CnaBeanCopierUtil.copy(productPo, Product.class);
    }
}

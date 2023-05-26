package cn.cnaworld.base.domain.product.repository.persistence;

import cn.cnaworld.base.domain.product.model.root.Product;
import cn.cnaworld.base.domain.product.repository.facade.ProductRepository;
import cn.cnaworld.base.domain.product.repository.orm.IProductPoService;
import cn.cnaworld.base.domain.product.repository.orm.po.ProductPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lucifer
 * @date 2023/5/25
 * @since 1.0.1.1
 */
@Service
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
    public Product queryProductById(Long productId) {
        ProductPo productPo = iProductPoService.getById(productId);
        Product product = (Product) productPo;
        return product;
    }
}

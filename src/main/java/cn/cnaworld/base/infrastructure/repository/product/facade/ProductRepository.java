package cn.cnaworld.base.infrastructure.repository.product.facade;

import cn.cnaworld.base.domain.product.model.root.Product;

/**
 * @author Lucifer
 * @date 2023/5/25
 * @since
 */

public interface ProductRepository {

    /**
     * 保存商品
     * @param product 商品
     */
   void saveProduct(Product product);

    /**
     * 查询商品
     * @param productId 商品Id
     * @return 商品信息
     */
    Product getProductById(Long productId);

}

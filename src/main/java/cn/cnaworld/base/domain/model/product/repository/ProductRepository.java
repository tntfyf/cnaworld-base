package cn.cnaworld.base.domain.model.product.repository;

import cn.cnaworld.base.domain.model.product.root.Product;

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

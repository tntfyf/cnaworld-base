package cn.cnaworld.base.domain.product.model.root;

import cn.cnaworld.base.domain.order.model.vo.OrderStatus;
import cn.cnaworld.base.infrastructure.repository.product.orm.po.ProductPo;
import cn.cnaworld.framework.infrastructure.exception.BusinessException;

/**
 * @author Lucifer
 * @date 2023/5/26
 * @since
 */
public class Product extends ProductPo {

    private String productStatus;

    public void checkValid(){
        if (productStatus == null || "cancel".equals(productStatus)){
            throw new BusinessException("商品已经失效");
        }
    }

}

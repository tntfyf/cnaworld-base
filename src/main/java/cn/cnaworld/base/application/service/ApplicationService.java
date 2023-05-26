package cn.cnaworld.base.application.service;

import cn.cnaworld.base.api.model.dto.OrderAndProductInfoDto;
import cn.cnaworld.base.application.assembler.Assembler;
import cn.cnaworld.base.domain.order.factory.OrderFactory;
import cn.cnaworld.base.domain.order.model.root.Order;
import cn.cnaworld.base.domain.product.model.root.Product;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @date 2023/5/25
 * @since
 */
@Service
public class ApplicationService {

    public OrderAndProductInfoDto getOrderAndProductInfo(long orderId){
        Order order = new OrderFactory()
                .orderId(orderId)
                .orderBuyerPhone("1")
                .build();
        Order orderInfo = order.getOrderInfo();
        Product product = new Product();
        product.setProductId(orderInfo.getGoods().getGoodsProductId());
        Product productInfo = product.getProductInfo();
        return Assembler.assembleOrderAndProduct(orderInfo,productInfo);
    }

}

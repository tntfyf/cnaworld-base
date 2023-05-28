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
        //使用订单领域工厂实例化订单领域聚合根对象
        Order order = new OrderFactory()
                .orderId(orderId)
                .orderBuyerPhone("1")
                .build();
        //调用领域服务方法
        Order orderInfo = order.getOrderInfo();
        //----------------------------------------------------------
        //实例化商品领域聚合根
        Product product = new Product();
        product.setProductId(orderInfo.getGoods().getGoodsProductId());
        //调用领域方法
        Product productInfo = product.getProductInfo();

        //将两个领域的返回信息进行适配转换成接入层DTO模型返回
        return Assembler.assembleOrderAndProduct(orderInfo,productInfo);
    }

}

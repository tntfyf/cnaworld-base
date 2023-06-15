package cn.cnaworld.base.domain.factory.order;

import cn.cnaworld.base.domain.model.order.entity.Goods;
import cn.cnaworld.base.domain.model.order.root.Order;
import cn.cnaworld.base.domain.model.order.vo.OrderStatus;

/**
 * @author Administrator
 * @date 2023/5/25
 * @since 1.0.1.1
 */
public class OrderFactory extends Order {

    public OrderFactory orderId(long orderId) {
        this.setOrderId(orderId);
        return this;
    }
    public OrderFactory orderTitle(String orderTitle) {
        this.setOrderTitle(orderTitle);
        return this;
    }
    public OrderFactory orderBuyerPhone(String orderBuyerPhone) {
        this.setOrderBuyerPhone(orderBuyerPhone);
        return this;
    }

    public OrderFactory buyerName(String buyerName) {
        this.setBuyerName(buyerName);
        return this;
    }

    public OrderFactory skuPropertiesName(String skuPropertiesName) {
        this.setSkuPropertiesName(skuPropertiesName);
        return this;
    }

    public OrderFactory goods(Goods goods) {
        this.setGoods(goods);
        return this;
    }

    public OrderFactory orderStatus(OrderStatus orderStatus) {
        this.setOrderStatus(orderStatus);
        return this;
    }

    public Order build(){
        return this;
    }
}

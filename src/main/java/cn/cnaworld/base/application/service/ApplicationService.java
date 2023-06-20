package cn.cnaworld.base.application.service;

import cn.cnaworld.base.api.model.dto.OrderAndProductInfoDto;
import cn.cnaworld.base.application.assembler.Assembler;
import cn.cnaworld.base.domain.order.factory.OrderFactory;
import cn.cnaworld.base.domain.order.model.entity.Goods;
import cn.cnaworld.base.domain.order.model.entity.GoodsExt;
import cn.cnaworld.base.domain.order.model.root.Order;
import cn.cnaworld.base.domain.order.model.vo.OrderStatus;
import cn.cnaworld.base.domain.order.service.OrderDomainService;
import cn.cnaworld.base.domain.product.model.root.Product;
import cn.cnaworld.base.infrastructure.repository.order.facade.OrderRepository;
import cn.cnaworld.base.infrastructure.repository.product.facade.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @date 2023/5/25
 * @since
 */
@Service
@Transactional
public class ApplicationService {

    //订单领域仓储
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderDomainService orderDomainService;

    public OrderAndProductInfoDto getOrderAndProductInfo(long orderId){
        Order order = orderRepository.getOrder(orderId);
        order.setOrderStatus(OrderStatus.success);
        //调用领域方法
        order.checkValid();
        //----------------------------------------------------------
        //实例化商品领域聚合根
        Product product = productRepository.getProductById(order.getGoods().getGoodsProductId());
        //调用领域方法
        product.checkValid();
        //将两个领域的返回信息进行适配转换成接入层DTO模型返回
        return Assembler.assembleOrderAndProduct(order,product);
    }

    public void createOrder(long orderId){
        //使用订单领域工厂实例化订单领域聚合根对象
        Order order = new OrderFactory()
                .orderId(orderId)
                .orderBuyerPhone("1")
                .build();
        //调用领域服务方法
        order.success();
    }

    public void domainLogicalProcessing(long orderId){
        //调用领域服务方法
        orderDomainService.domainLogicalProcessing();
    }

    public void orderLazy(long orderId){
        //使用订单领域工厂实例化订单领域聚合根对象
        Order order = orderRepository.getOrderLazy(orderId);
        //懒加载，且保持同一事务中
        Goods goods  = order.getGoods();
        order.setGoods(null);
        Goods goods1 = order.getGoods();
        GoodsExt goodsExt = goods.getGoodsExt();
        System.out.println(goods);
        System.out.println(goodsExt);
    }



}

package cn.cnaworld.base.application.service;

import cn.cnaworld.base.api.model.dto.OrderAndProductInfoDto;
import cn.cnaworld.base.application.assembler.Assembler;
import cn.cnaworld.base.domain.factory.order.OrderFactory;
import cn.cnaworld.base.domain.model.order.root.Order;
import cn.cnaworld.base.domain.model.order.service.OrderDomainService;
import cn.cnaworld.base.domain.model.product.repository.ProductRepository;
import cn.cnaworld.base.domain.model.product.root.Product;
import cn.cnaworld.base.infrastructure.utils.SpringBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @date 2023/5/25
 * @since
 */
@Service
public class ApplicationService {

    @Autowired
    private OrderDomainService orderDomainService;

    @Autowired
    private ProductRepository productRepository;

    public OrderAndProductInfoDto getOrderAndProductInfo(long orderId){
        //使用订单领域工厂实例化订单领域聚合根对象
        Order order = new OrderFactory()
                .orderId(orderId)
                .orderBuyerPhone("1")
                .build();
        //调用领域服务方法
        Order orderInfo = order.getOrderInfo();
        //----------------------------------------------------------
        //也可以从仓储直接拿对象
        Product product = productRepository.getProductById(orderInfo.getGoods().getGoodsProductId());
        //调用领域方法
        //将两个领域的返回信息进行适配转换成接入层DTO模型返回
        return Assembler.assembleOrderAndProduct(orderInfo,product);
    }

    public void domainLogicalProcessing(long orderId){
        //调用订单领域服务处理领域中聚合根值对象实体之间的业务逻辑
        orderDomainService.domainLogicalProcessing(orderId);
    }

    public void createOrder(long orderId){
        //下单成功触发领域事件
        Order order = new OrderFactory()
                .orderId(orderId)
                .orderBuyerPhone("1")
                .build();
        //调用领域服务方法
        order.success();
    }

}

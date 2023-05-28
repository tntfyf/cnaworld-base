package cn.cnaworld.base.domain.product.service.impl;

import cn.cnaworld.base.domain.order.repository.facade.OrderRepository;
import cn.cnaworld.base.domain.order.service.OrderDomainService;
import cn.cnaworld.base.domain.product.service.ProductrDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @date 2023/5/28
 * @since
 */
@Service
public class ProductDomainServiceImpl implements ProductrDomainService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void domainLogicalProcessing() {
        System.out.println("处理领域中聚合与实体或者值对象之间的业务逻辑");
        System.out.println("仓储进行处理");
    }
}

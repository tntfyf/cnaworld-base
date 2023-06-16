package cn.cnaworld.base.domain.model.order.service.impl;

import cn.cnaworld.base.domain.model.order.repository.OrderRepository;
import cn.cnaworld.base.domain.model.order.service.OrderDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @date 2023/5/28
 * @since
 */
@Service
public class OrderDomainServiceImpl implements OrderDomainService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void domainLogicalProcessing(long orderId) {
        System.out.println("处理领域中聚合与实体或者值对象之间的业务逻辑");
        System.out.println("仓储进行处理");
    }
}

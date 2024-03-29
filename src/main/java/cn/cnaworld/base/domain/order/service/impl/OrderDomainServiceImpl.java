package cn.cnaworld.base.domain.order.service.impl;

import cn.cnaworld.base.domain.order.service.OrderDomainService;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @date 2023/5/28
 * @since
 */
@Service
public class OrderDomainServiceImpl implements OrderDomainService {

    @Override
    public void domainLogicalProcessing() {
        System.out.println("处理领域中聚合与实体或者值对象之间的业务逻辑");
        System.out.println("仓储进行处理");
    }
}

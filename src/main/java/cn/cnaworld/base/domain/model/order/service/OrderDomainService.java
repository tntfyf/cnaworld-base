package cn.cnaworld.base.domain.model.order.service;

/**
 * 订单领域服务
 * @author Administrator
 * @date 2023/5/25
 * @since 1.0.1.1
 */
public interface OrderDomainService {

    void domainLogicalProcessing(long orderId);

}

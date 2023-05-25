package cn.cnaworld.base.domain.order.repository.persistence;

import cn.cnaworld.base.domain.order.model.entity.Goods;
import cn.cnaworld.base.domain.order.model.root.Order;
import cn.cnaworld.base.domain.order.repository.facade.OrderRepository;
import cn.cnaworld.base.domain.order.repository.orm.IGoodsPoService;
import cn.cnaworld.base.domain.order.repository.orm.IOrderPoService;
import cn.cnaworld.base.domain.order.repository.orm.po.GoodsPo;
import cn.cnaworld.base.domain.order.repository.orm.po.OrderPo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lucifer
 * @date 2023/5/25
 * @since 1.0.1.1
 */
@Service
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private IGoodsPoService iGoodsPoService;

    @Autowired
    private IOrderPoService iOrderPoService;

    /**
     * 保存聚合根
     *
     * @param order 订单
     */
    @Override
    public void saveOrder(Order order) {

        if(order!=null){
            iOrderPoService.save(order);
            if(order.getGoods()!=null){
                iGoodsPoService.save(order.getGoods());
            }
        }

    }


    /**
     * 查询订单
     *
     * @param orderId 订单Id
     */
    @Override
    public Order queryOrderById(Long orderId) {
        OrderPo orderPo = iOrderPoService.getById(orderId);
        Order order = (Order) orderPo;
        QueryWrapper<GoodsPo> queryWrapper = new QueryWrapper<GoodsPo>();
        queryWrapper.eq("goods_order_id",order.getOrderId());
        GoodsPo goodsPo = iGoodsPoService.getOne(queryWrapper);
        order.setGoods((Goods) goodsPo);
        return order;
    }
}

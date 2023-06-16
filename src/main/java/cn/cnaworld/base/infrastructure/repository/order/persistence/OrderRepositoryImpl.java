package cn.cnaworld.base.infrastructure.repository.order.persistence;

import cn.cnaworld.base.domain.order.model.entity.Goods;
import cn.cnaworld.base.domain.order.model.root.Order;
import cn.cnaworld.base.infrastructure.repository.order.facade.OrderRepository;
import cn.cnaworld.base.infrastructure.repository.order.orm.IGoodsPoService;
import cn.cnaworld.base.infrastructure.repository.order.orm.IOrdersPoService;
import cn.cnaworld.base.infrastructure.repository.order.orm.po.GoodsPo;
import cn.cnaworld.base.infrastructure.repository.order.orm.po.OrdersPo;
import cn.cnaworld.base.infrastructure.utils.BeanCopierUtil;
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
    private IOrdersPoService iOrdersPoService;

    /**
     * 保存聚合根
     *
     * @param order 订单
     */
    @Override
    public void saveOrder(Order order) {

        if(order!=null){
            iOrdersPoService.save(order);
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
    public Order getOrderById(Long orderId) {
        //仓储实际调用ORM框架进行查询
        OrdersPo ordersPo = iOrdersPoService.getById(orderId);
        //PO到DO转换
        Order order = BeanCopierUtil.copy(ordersPo, Order.class);
        //未来考虑实体懒加载查询设计
        QueryWrapper<GoodsPo> queryWrapper = new QueryWrapper<GoodsPo>();
        queryWrapper.eq("goods_order_id",order.getOrderId());
        GoodsPo goodsPo = iGoodsPoService.getOne(queryWrapper);
        //PO到DO转换
        Goods goods = BeanCopierUtil.copy(goodsPo, Goods.class);
        order.setGoods(goods);
        return order;
    }
}

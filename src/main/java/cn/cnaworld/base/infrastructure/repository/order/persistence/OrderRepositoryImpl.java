package cn.cnaworld.base.infrastructure.repository.order.persistence;

import cn.cnaworld.base.domain.order.model.entity.Goods;
import cn.cnaworld.base.domain.order.model.root.Order;
import cn.cnaworld.base.infrastructure.repository.order.facade.OrderRepository;
import cn.cnaworld.base.infrastructure.repository.order.orm.service.IGoodsPoService;
import cn.cnaworld.base.infrastructure.repository.order.orm.service.IOrdersPoService;
import cn.cnaworld.base.infrastructure.repository.order.orm.po.GoodsPo;
import cn.cnaworld.base.infrastructure.repository.order.orm.po.OrdersPo;
import cn.cnaworld.framework.infrastructure.utils.bean.CnaBeanCopierUtil;
import cn.cnaworld.framework.infrastructure.utils.cglib.AggEntityLazyFactory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucifer
 * @date 2023/5/25
 * @since 1.0.1.1
 */
@Service
@Transactional
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
    public Order getOrderLazy(Long orderId) {
        //仓储实际调用ORM框架进行查询
        OrdersPo ordersPo = iOrdersPoService.getById(orderId);
        Order order = AggEntityLazyFactory.initAggEntity(Order.class);
        CnaBeanCopierUtil.copy(ordersPo, order);
        return order;
    }

    /**
     * 查询订单
     *
     * @param orderId 订单Id
     * @return 订单信息
     */
    @Override
    public Order getOrder(Long orderId) {
        //仓储实际调用ORM框架进行查询
        OrdersPo ordersPo = iOrdersPoService.getById(orderId);
        Order order = CnaBeanCopierUtil.copy(ordersPo, Order.class);
        //PO到DO转换
        QueryWrapper<GoodsPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("goods_order_id",order.getOrderId());
        GoodsPo goodsPo = iGoodsPoService.getOne(queryWrapper);
        //PO到DO转换
        Goods goods = CnaBeanCopierUtil.copy(goodsPo, Goods.class);
        order.setGoods(goods);
        return order;
    }

    @Override
    public void testAutoEncrypt(Long orderId) {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(1382408225431552L);
        ids.add(1382414513201152L);
        List<OrdersPo> ordersPos = iOrdersPoService.listByIds(ids);
        //OrdersPo ordersPo = iOrdersPoService.getById(orderId);
        System.out.println(ordersPos);
//        ordersPo.setOrderId(null);
//        iOrdersPoService.save(ordersPo);
    }
}

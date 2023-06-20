package cn.cnaworld.base.infrastructure.repository.order.persistence;

import cn.cnaworld.base.domain.order.model.entity.Goods;
import cn.cnaworld.base.domain.order.model.entity.GoodsExt;
import cn.cnaworld.base.domain.order.model.root.Order;
import cn.cnaworld.base.infrastructure.repository.order.orm.po.GoodsExtPo;
import cn.cnaworld.base.infrastructure.repository.order.orm.service.IGoodsExtPoService;
import cn.cnaworld.base.infrastructure.repository.order.orm.service.IGoodsPoService;
import cn.cnaworld.base.infrastructure.repository.order.orm.po.GoodsPo;
import cn.cnaworld.framework.infrastructure.component.repositorylazy.CnaRepositoryLazyProcessor;
import cn.cnaworld.framework.infrastructure.utils.bean.CnaBeanCopierUtil;
import cn.cnaworld.framework.infrastructure.utils.bean.CnaSpringBeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.ObjectUtils;

/**
 * @author Lucifer
 */
public class OrderLazy {

    public static class LazyGetGoods implements CnaRepositoryLazyProcessor {
        //懒加载遵循调用类事务
        @Override
        public Object processing(Object o) {
            IGoodsPoService iGoodsPoService= CnaSpringBeanUtil.getBean(IGoodsPoService.class);
            Order order=(Order) o;
            if(ObjectUtils.isNotEmpty(order.getOrderId())){
                QueryWrapper<GoodsPo> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("goods_order_id",order.getOrderId());
                GoodsPo goodsPo = iGoodsPoService.getOne(queryWrapper);
                if(ObjectUtils.isNotEmpty(goodsPo)){
                    //PO到DO转换
                    return CnaBeanCopierUtil.copy(goodsPo, Goods.class);
                }
            }
            return null;
        }
    }

    public static class LazyGetGoodsExt implements CnaRepositoryLazyProcessor {
        //懒加载遵循调用类事务
        @Override
        public Object processing(Object o) {
            IGoodsExtPoService iGoodsExtPoService= CnaSpringBeanUtil.getBean(IGoodsExtPoService.class);
            Goods goods=(Goods) o;
            if(ObjectUtils.isNotEmpty(goods.getGoodsId())){
                QueryWrapper<GoodsExtPo> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("goods_id",goods.getGoodsId());
                GoodsExtPo goodsExtPo = iGoodsExtPoService.getOne(queryWrapper);
                if(ObjectUtils.isNotEmpty(goodsExtPo)){
                    //PO到DO转换
                    return CnaBeanCopierUtil.copy(goodsExtPo, GoodsExt.class);
                }
            }
            return null;
        }
    }

}

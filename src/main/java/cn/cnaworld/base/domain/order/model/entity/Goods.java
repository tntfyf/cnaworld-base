package cn.cnaworld.base.domain.order.model.entity;



import cn.cnaworld.base.infrastructure.repository.order.orm.po.GoodsPo;
import cn.cnaworld.base.infrastructure.repository.order.persistence.OrderLazy;
import cn.cnaworld.framework.infrastructure.component.repositorylazy.annotation.CnaLazy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Lucifer
 * @date 2023/5/25
 * @since 1.0.1.1
 */
@Setter
@Getter
@ToString(callSuper=true)
public class Goods extends GoodsPo implements Serializable {

    @CnaLazy(LazyProcessor = OrderLazy.LazyGetGoodsExt.class)
    private GoodsExt goodsExt;

}

package cn.cnaworld.base.infrastructure.repository.order.orm.mapper;

import cn.cnaworld.base.infrastructure.repository.order.orm.po.OrdersPo;
import cn.cnaworld.framework.infrastructure.component.mybatisplus.baseclass.mapper.CnaworldBaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lucifer
 * @since 2023-06-23
 */
public interface OrdersPoMapper extends CnaworldBaseMapper<OrdersPo> {
   OrdersPo selectOneById();

   int updateOneById(@Param("orderTitle")String orderTitle,@Param("buyerName")String buyerName);

   int deleteOneById();
}

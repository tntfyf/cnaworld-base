package cn.cnaworld.base.infrastructure.repository.order.orm.mapper;

import cn.cnaworld.base.infrastructure.repository.order.orm.po.OrdersPo;
import cn.cnaworld.framework.infrastructure.component.mybatisplus.baseclass.mapper.CnaworldBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lucifer
 * @since 2023-06-23
 */
@Mapper
public interface OrdersPoMapper extends CnaworldBaseMapper<OrdersPo> {
   OrdersPo selectOneById();

   int updateOneById(OrdersPo ordersPo);

   int updateListById(List<OrdersPo> ordersPoList);

   @Select("SELECT encrypt FROM orders")
   List<OrdersPo> selectVO2();

}

package cn.cnaworld.base.application.assembler;

import cn.cnaworld.base.api.model.dto.OrderAndProductInfoDto;
import cn.cnaworld.base.domain.order.model.root.Order;
import cn.cnaworld.base.domain.product.model.root.Product;
import cn.cnaworld.framework.infrastructure.utils.bean.CnaBeanCopierUtil;

/**
 * @author Lucifer
 * @date 2023/5/26
 * @since
 */
public class Assembler {

    public static OrderAndProductInfoDto assembleOrderAndProduct(Order order, Product product) {

        if(order == null || product == null) {
            return null;
        }
        OrderAndProductInfoDto orderAndProductInfoDto = new OrderAndProductInfoDto();
        CnaBeanCopierUtil.copy(order,orderAndProductInfoDto);
        return orderAndProductInfoDto;
    }


}

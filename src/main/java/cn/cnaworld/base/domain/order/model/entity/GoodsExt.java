package cn.cnaworld.base.domain.order.model.entity;


import cn.cnaworld.base.infrastructure.repository.order.orm.po.GoodsExtPo;
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
public class GoodsExt extends GoodsExtPo implements Serializable {


}

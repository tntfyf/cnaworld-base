package cn.cnaworld.base.domain.order.repository.orm.po;

import cn.cnaworld.base.infrastructure.component.baseclass.CnaWorldBaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lucifer
 * @since 2023-05-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("goods")
@ApiModel(value = "GoodsPo对象", description = "")
public class GoodsPo extends CnaWorldBaseEntity {


    @ApiModelProperty(value = "商品ID")
    @TableId(value = "goods_id", type = IdType.ASSIGN_ID)
    private Long goodsId;

    @ApiModelProperty(value = "所属订单ID")
    @TableField("goods_order_id")
    private Long goodsOrderId;

    @ApiModelProperty(value = "商品归属产品ID")
    @TableField("goods_product_id")
    private Long goodsProductId;


}

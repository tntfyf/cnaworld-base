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
 * @since 2023-05-26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("orders")
@ApiModel(value = "OrdersPo对象", description = "")
public class OrdersPo extends CnaWorldBaseEntity {


    @ApiModelProperty(value = "订单ID")
    @TableId(value = "order_id", type = IdType.ASSIGN_ID)
    private Long orderId;

    @ApiModelProperty(value = "订单标题")
    @TableField("order_title")
    private String orderTitle;

    @ApiModelProperty(value = "订单购买电话")
    @TableField("order_buyer_phone")
    private String orderBuyerPhone;

    @ApiModelProperty(value = "订单购买人名称")
    @TableField("buyer_name")
    private String buyerName;

    @ApiModelProperty(value = "订单规格")
    @TableField("sku_properties_name")
    private String skuPropertiesName;


}

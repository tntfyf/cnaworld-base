package cn.cnaworld.base.infrastructure.repository.book.orm.po;

import cn.cnaworld.framework.infrastructure.component.mybatisplus.baseclass.entity.CnaworldBaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lucifer
 * @since 2023-08-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("book")
@Schema(name = "BookPo对象", description = "")
public class BookPo extends CnaworldBaseEntity {


    @Schema(description = "订单ID")
    @TableId(value = "order_id", type = IdType.ASSIGN_ID)
    private Long orderId;

    @Schema(description = "订单标题")
    @TableField("order_title")
    private String orderTitle;

    @Schema(description = "订单购买电话")
    @TableField("order_buyer_phone")
    private String orderBuyerPhone;

    @Schema(description = "订单购买人名称")
    @TableField("buyer_name")
    private String buyerName;

    @Schema(description = "订单规格")
    @TableField("sku_properties_name")
    private String skuPropertiesName;

    @Schema(description = "自动加解密")
    private String encrypt;


}

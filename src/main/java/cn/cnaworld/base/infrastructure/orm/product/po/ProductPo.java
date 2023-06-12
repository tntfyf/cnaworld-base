package cn.cnaworld.base.infrastructure.orm.product.po;

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
@TableName("product")
@ApiModel(value = "ProductPo对象", description = "")
public class ProductPo extends CnaWorldBaseEntity {


    @ApiModelProperty(value = "商品ID")
    @TableId(value = "product_id", type = IdType.ASSIGN_ID)
    private Long productId;

    @ApiModelProperty(value = "商品标题")
    @TableField("product_title")
    private String productTitle;

    @ApiModelProperty(value = "商品SKUID")
    @TableField("product_skuid")
    private String productSkuid;

    @ApiModelProperty(value = "商品总量")
    @TableField("product_num")
    private Integer productNum;

    @ApiModelProperty(value = "商品库存")
    @TableField("product_last_num")
    private Integer productLastNum;


}

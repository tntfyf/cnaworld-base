package cn.cnaworld.base.infrastructure.repository.product.orm.po;

import cn.cnaworld.framework.infrastructure.component.mybatisplus.baseclass.entity.CnaworldBaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lucifer
 * @since 2023-05-26
 */
@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper = true)
@TableName("product")
@Schema(name = "ProductPo对象", description = "")
public class ProductPo extends CnaworldBaseEntity {


    @Schema(description = "商品ID")
    @TableId(value = "product_id", type = IdType.ASSIGN_ID)
    private Long productId;

    @Schema(description = "商品标题")
    @TableField("product_title")
    private String productTitle;

    @Schema(description = "商品SKUID")
    @TableField("product_skuid")
    private String productSkuid;

    @Schema(description = "商品总量")
    @TableField("product_num")
    private Integer productNum;

    @Schema(description = "商品库存")
    @TableField("product_last_num")
    private Integer productLastNum;


}

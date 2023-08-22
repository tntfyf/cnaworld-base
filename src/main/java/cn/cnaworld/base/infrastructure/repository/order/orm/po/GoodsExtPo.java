package cn.cnaworld.base.infrastructure.repository.order.orm.po;

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
 * @since 2023-06-20
 */
@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper = true)
@TableName("goods_ext")
@Schema(name = "GoodsExtPo对象", description = "")
public class GoodsExtPo extends CnaworldBaseEntity {


    @Schema(description = "商品ID")
    @TableId(value = "goods_ext_id", type = IdType.ASSIGN_ID)
    private Long goodsExtId;

    @Schema(description = "所属订单ID")
    @TableField("goods_id")
    private Long goodsId;


}

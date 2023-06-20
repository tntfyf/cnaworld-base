package cn.cnaworld.base.infrastructure.repository.order.orm.po;

import cn.cnaworld.base.infrastructure.component.baseclass.CnaWorldBaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

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
@ApiModel(value = "GoodsExtPo对象", description = "")
public class GoodsExtPo extends CnaWorldBaseEntity {


    @ApiModelProperty(value = "商品ID")
    @TableId(value = "goods_ext_id", type = IdType.ASSIGN_ID)
    private Long goodsExtId;

    @ApiModelProperty(value = "所属订单ID")
    @TableField("goods_id")
    private Long goodsId;


}

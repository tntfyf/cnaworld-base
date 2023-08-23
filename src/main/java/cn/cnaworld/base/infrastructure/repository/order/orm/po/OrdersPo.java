package cn.cnaworld.base.infrastructure.repository.order.orm.po;

import cn.cnaworld.framework.infrastructure.component.mybatisplus.annotation.CnaFieldEncrypt;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lucifer
 * @since 2023-06-23
 */
@Getter
@Setter
@ToString(callSuper=true)
@EqualsAndHashCode(callSuper = true)
@TableName("orders")
@Schema(name = "OrdersPo对象",description = "OrdersPo对象 OrdersPo对象")
public class OrdersPo extends CnaworldBaseEntity {

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

    @TableField("encrypt")
    private String encrypt;

    @CnaFieldEncrypt
    @TableField("encrypt_short")
    private short encryptShort;

    @CnaFieldEncrypt
    @TableField("encrypt_byte")
    private byte encryptByte;

    @CnaFieldEncrypt
    @TableField("encrypt_int")
    private int encryptInt;

    @CnaFieldEncrypt
    @TableField("encrypt_long")
    private long encryptLong;

    @CnaFieldEncrypt
    @TableField("encrypt_double")
    private double encryptDouble;

    @CnaFieldEncrypt
    @TableField("encrypt_float")
    private float encryptFloat;

    @CnaFieldEncrypt
    @TableField("encrypt_big_decimal")
    private BigDecimal encryptBigDecimal;

    @CnaFieldEncrypt
    @TableField("encrypt_boolean")
    private boolean encryptBoolean;

    @CnaFieldEncrypt
    @TableField("encrypt_time")
    private Date encryptTime;

    @CnaFieldEncrypt
    @TableField("encrypt_local_time")
    private LocalDateTime encryptLocalTime;

    @TableField("encrypt_local_date")
    private LocalDate encryptLocalDate;

}

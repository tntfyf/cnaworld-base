package cn.cnaworld.base.api.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Administrator
 * @date 2023/5/26
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
@Schema
public class OrderAndProductInfoDto {
    @Schema(example = "1")
    private long orderId;
    @Schema(example = "sss")
    private String orderTitle;
    @Schema(example = "3")
    private long goodsId;
    @Schema(example = "4")
    private int productNum;
    @Schema(example = "5")
    private int productLastNum;

}

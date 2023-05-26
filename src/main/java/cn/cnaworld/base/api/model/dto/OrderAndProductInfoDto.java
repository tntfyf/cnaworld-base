package cn.cnaworld.base.api.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Administrator
 * @date 2023/5/26
 * @since
 */
@Getter
@Setter
@ToString
public class OrderAndProductInfoDto {

    private long orderId;

    private String orderTitle;

    private long goodsId;

    private int productNum;

    private int productLastNum;

}

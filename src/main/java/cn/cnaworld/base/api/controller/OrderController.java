package cn.cnaworld.base.api.controller;


import cn.cnaworld.base.api.model.dto.OrderAndProductInfoDto;
import cn.cnaworld.base.application.service.ApplicationService;
import cn.cnaworld.framework.infrastructure.annotation.CnaAopLog;
import cn.cnaworld.framework.infrastructure.utils.http.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接入层，负责domain领域间协调 ，只有Controller 和 service。不与实体直接交互。
 * @author Lucifer
 * @date 2023/2/1
 * @since 1.0
 */
@RestController
@RequestMapping("/order/v1")
@Api(tags = "订单接口层")
public class OrderController {

    @Autowired
    private ApplicationService applicationService;


    /**
     * 同时查询返回两个Domain下的数据
     * @author Lucifer
     * @date 2023/3/10
     * @since 1.0.0
     * @param orderId String
     * @return ResponseResult<StudentAndTeacherDto>
     */
    @GetMapping("/getOrderInfo/{orderId}")
    @CnaAopLog
    @ApiOperation("查询订单数据及库存数据")
    public ResponseResult<OrderAndProductInfoDto> getOrderInfo(@PathVariable long orderId){
        return ResponseResult.success(applicationService.getOrderAndProductInfo(orderId));
    }

}

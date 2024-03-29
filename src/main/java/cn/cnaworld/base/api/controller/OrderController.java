package cn.cnaworld.base.api.controller;


import cn.cnaworld.base.api.model.dto.OrderAndProductInfoDto;
import cn.cnaworld.base.application.service.ApplicationService;
import cn.cnaworld.framework.infrastructure.annotation.CnaAopLog;
import cn.cnaworld.framework.infrastructure.utils.http.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接入层
 * @author Lucifer
 * @date 2023/2/1
 * @since 1.0
 */
@RestController
@RequestMapping("/order/v1")
@Tag(name = "订单接口层")
public class OrderController {
    //接入层负责处理用户请求，解析参数，转换数据格式等
    @Autowired
    private ApplicationService applicationService;

    /**
     * 接入层响应外部请求
     * 同时查询返回两个Domain下的数据
     * @author Lucifer
     * @date 2023/3/10
     * @since 1.0.0
     * @param orderId String
     * @return ResponseResult<StudentAndTeacherDto>
     */
    @GetMapping("/getOrderInfo/{orderId}")
    @CnaAopLog
    @Operation(summary ="查询订单数据及库存数据")
    public ResponseResult<OrderAndProductInfoDto> getOrderInfo(@PathVariable String orderId){
        long orderIdLong=Long.parseLong(orderId);
        //应用层服务响应接入层的请求，开始进行领域服务编排
        return ResponseResult.success(applicationService.getOrderAndProductInfo(orderIdLong));
    }

    /**
     * 接入层响应外部请求
     */
    @GetMapping("/domainLogicalProcessing/{orderId}")
    @CnaAopLog
    @Operation(summary ="调用订单领域服务处理领域中聚合根值对象实体之间的业务逻辑据")
    public ResponseResult<String> domainLogicalProcessing(@PathVariable long orderId){
        applicationService.domainLogicalProcessing(orderId);
        return ResponseResult.success();
    }

    /**
     * 接入层响应外部请求
     */
    @GetMapping("/domainEvent/{orderId}")
    @CnaAopLog
    @Operation(summary ="领域事件传播，下单成功通知商品领域下单成功事件")
    public ResponseResult<String> createOrder(@PathVariable long orderId){
        applicationService.createOrder(orderId);
        return ResponseResult.success();
    }

    /**
     * 懒加载
     */
    @GetMapping("/orderLazy/{orderId}")
    @Operation(summary ="聚合根懒加载实体")
    public ResponseResult<String> orderLazy(@PathVariable long orderId){
        applicationService.orderLazy(orderId);
        return ResponseResult.success();
    }

}

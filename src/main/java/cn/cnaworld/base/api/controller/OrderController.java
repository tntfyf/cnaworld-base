package cn.cnaworld.base.api.controller;


import cn.cnaworld.base.api.model.dto.*;
import cn.cnaworld.base.application.service.ApplicationService;
import cn.cnaworld.base.domain.order.factory.OrderFactory;
import cn.cnaworld.base.domain.order.model.root.Order;
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
 * 接入层
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
    @ApiOperation("查询订单数据及库存数据")
    public ResponseResult<OrderAndProductInfoDto> getOrderInfo(@PathVariable long orderId){
        //应用层服务响应接入层的请求，开始进行领域服务编排
        return ResponseResult.success(applicationService.getOrderAndProductInfo(orderId));
    }

    /**
     * 接入层响应外部请求
     */
    @GetMapping("/domainLogicalProcessing/{orderId}")
    @CnaAopLog
    @ApiOperation("调用订单领域服务处理领域中聚合根值对象实体之间的业务逻辑据")
    public ResponseResult<String> domainLogicalProcessing(@PathVariable long orderId){
        //使用订单领域工厂实例化订单领域聚合根对象
        Order order = new OrderFactory()
                .orderId(orderId)
                .orderBuyerPhone("1")
                .build();
        //调用领域服务方法
        order.domainLogicalProcessing();
        return ResponseResult.success();
    }

    /**
     * 接入层响应外部请求
     */
    @GetMapping("/domainEvent/{orderId}")
    @CnaAopLog
    @ApiOperation("领域事件传播，下单成功通知商品领域下单成功事件")
    public ResponseResult<String> domainEvent(@PathVariable long orderId){
        //使用订单领域工厂实例化订单领域聚合根对象
        Order order = new OrderFactory()
                .orderId(orderId)
                .orderBuyerPhone("1")
                .build();
        //调用领域服务方法
        order.success();
        return ResponseResult.success();
    }

}

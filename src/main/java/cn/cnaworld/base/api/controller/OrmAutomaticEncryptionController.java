package cn.cnaworld.base.api.controller;


import cn.cnaworld.base.api.model.dto.OrderAndProductInfoDto;
import cn.cnaworld.base.application.service.ApplicationService;
import cn.cnaworld.base.infrastructure.repository.order.orm.mapper.OrdersPoMapper;
import cn.cnaworld.base.infrastructure.repository.order.orm.po.OrdersPo;
import cn.cnaworld.base.infrastructure.repository.order.orm.service.IOrdersPoService;
import cn.cnaworld.framework.infrastructure.annotation.CnaAopLog;
import cn.cnaworld.framework.infrastructure.utils.http.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
@RequestMapping("/autoEncrypt/v1")
@Api(tags = "订单接口层")
public class OrmAutomaticEncryptionController {
    //接入层负责处理用户请求，解析参数，转换数据格式等
    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private IOrdersPoService iOrdersPoService;

    @Autowired
    private OrdersPoMapper ordersPoMapper;




    /**
     * 接入层响应外部请求
     * 同时查询返回两个Domain下的数据
     * @author Lucifer
     * @date 2023/3/10
     * @since 1.0.0
     * @param orderId String
     * @return ResponseResult<StudentAndTeacherDto>
     */
    @GetMapping("/test/{orderId}")
    @CnaAopLog
    @ApiOperation("测试orm自动加密")
    public ResponseResult<OrderAndProductInfoDto> getOrderInfo(@PathVariable String orderId){
        long orderIdLong=Long.parseLong(orderId);
        //应用层服务响应接入层的请求，开始进行领域服务编排
        applicationService.testAutoEncrypt(orderIdLong);
        return ResponseResult.success();
    }

    /**
     * 接入层响应外部请求
     * 同时查询返回两个Domain下的数据
     * @author Lucifer
     * @date 2023/3/10
     * @since 1.0.0
     * @return ResponseResult<StudentAndTeacherDto>
     */
    @GetMapping("/testOneObject")
    @CnaAopLog
    @ApiOperation("测试orm自动加密")
    public ResponseResult<OrderAndProductInfoDto> testOneObject(){
        //ordersPoMapper.deleteOneById();
        //应用层服务响应接入层的请求，开始进行领域服务编排
        //OrdersPo ordersPo = ordersPoMapper.selectOneById();
        //ordersPo.setOrderId(1384886029656064L);
        //UpdateWrapper<OrdersPo> updateWrapper= new UpdateWrapper<>();
        //updateWrapper.set("encrypt","830362A01BAA4A3EBE984EF34304F55821FF202F73665C3913E08B440F55A340E8898779CBA4A46EBFDF20793024978B");
        ordersPoMapper.updateOneById("aaa","bbb");

        //ordersPoMapper.insert(ordersPo);
        return ResponseResult.success();
    }

}

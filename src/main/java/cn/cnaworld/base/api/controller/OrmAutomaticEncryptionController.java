package cn.cnaworld.base.api.controller;


import cn.cnaworld.base.api.model.dto.OrderAndProductInfoDto;
import cn.cnaworld.base.application.service.ApplicationService;
import cn.cnaworld.base.infrastructure.repository.order.orm.mapper.OrdersPoMapper;
import cn.cnaworld.base.infrastructure.repository.order.orm.po.OrdersPo;
import cn.cnaworld.base.infrastructure.repository.order.orm.service.IOrdersPoService;
import cn.cnaworld.framework.infrastructure.annotation.CnaAopLog;
import cn.cnaworld.framework.infrastructure.utils.bean.CnaBeanCopierUtil;
import cn.cnaworld.framework.infrastructure.utils.http.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 接入层
 * @author Lucifer
 * @date 2023/2/1
 * @since 1.0
 */
@RestController
@RequestMapping("/autoEncrypt/v1")
@Tag(name = "自动加密解密")
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
    @Operation(summary ="测试orm自动加密")
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
    @GetMapping("/objInsert")
    @Operation(summary ="自动加密objInsert")
    public ResponseResult<OrdersPo> objInsert(){
        byte a = -123;
        short b = -1234;
        OrdersPo ordersPo = ordersPoMapper.selectById(1);
        ordersPo.setOrderId(null);
        ordersPo.setEncrypt("自动加密objInsert"+new Date());
        ordersPo.setEncryptBoolean(false);
        ordersPo.setEncryptLong(-123456789L);
        ordersPo.setEncryptInt(-123456789);
        ordersPo.setEncryptBigDecimal(new BigDecimal("-123456789.5"));
        ordersPo.setEncryptDouble(-123456789.123456789);
        ordersPo.setEncryptFloat(-123456789.123456789F);
        ordersPo.setEncryptShort(b);
        ordersPo.setEncryptByte(a);
        ordersPo.setEncryptTime(new Date());
        ordersPo.setEncryptLocalTime(LocalDateTime.now());
        ordersPo.setEncryptLocalDate(LocalDate.now());
        iOrdersPoService.save(ordersPo);
        return ResponseResult.success(ordersPo);
    }

    @GetMapping("/listInsert")
    @Operation(summary ="自动加密listInsert")
    public ResponseResult<List<OrdersPo>> listInsert(){
        byte a = -123;
        short b = -1234;
        OrdersPo ordersPo = ordersPoMapper.selectById(1);
        List<OrdersPo> ordersPoList=new ArrayList<>();
        ordersPo.setOrderId(null);
        ordersPo.setEncrypt("自动加密listInsert - 1"+new Date());
        ordersPo.setEncryptBoolean(false);
        ordersPo.setEncryptLong(-123456789L);
        ordersPo.setEncryptInt(-123456789);
        ordersPo.setEncryptBigDecimal(new BigDecimal("-123456789.5"));
        ordersPo.setEncryptDouble(-123456789.123456789);
        ordersPo.setEncryptFloat(-123456789.123456789F);
        ordersPo.setEncryptShort(b);
        ordersPo.setEncryptByte(a);
        ordersPo.setEncryptTime(new Date());
        ordersPo.setEncryptLocalTime(LocalDateTime.now());
        ordersPo.setEncryptLocalDate(LocalDate.now());
        OrdersPo ordersPo1 = new OrdersPo();
        CnaBeanCopierUtil.copy(ordersPo,ordersPo1);
        ordersPo1.setEncrypt("自动加密listInsert - 2"+new Date());
        ordersPoList.add(ordersPo);
        ordersPoList.add(ordersPo1);
        iOrdersPoService.saveBatch(ordersPoList);
        return ResponseResult.success(ordersPoList);
    }

    @GetMapping("/objSelect")
    @Operation(summary ="objSelect")
    @CnaAopLog
    public ResponseResult<OrdersPo> objSelect(Long id){
        OrdersPo ordersPo = iOrdersPoService.getById(id);
        return ResponseResult.success(ordersPo);
    }

    @GetMapping("/listSelect")
    @Operation(summary ="listSelect")
    public ResponseResult<List<OrdersPo>> listSelect(@RequestParam List<Long> ids){
        List<OrdersPo> ordersPo = iOrdersPoService.listByIds(ids);
        return ResponseResult.success(ordersPo);
    }

    @GetMapping("/objUpdate")
    @Operation(summary ="自动加密objUpdate")
    public ResponseResult<OrdersPo> objUpdate(){
        byte a = -21;
        short b = -4321;
        OrdersPo ordersPo = iOrdersPoService.getById(1386290580283393L);
        ordersPo.setEncrypt("自动加密objUpdate"+new Date());
        ordersPo.setEncryptBoolean(true);
        ordersPo.setEncryptLong(-987654321L);
        ordersPo.setEncryptInt(-987654321);
        ordersPo.setEncryptBigDecimal(new BigDecimal("-987654321.5"));
        ordersPo.setEncryptDouble(-987654321.123456789);
        ordersPo.setEncryptFloat(-987654321.123456789F);
        ordersPo.setEncryptShort(b);
        ordersPo.setEncryptByte(a);
        ordersPo.setEncryptTime(new Date());
        ordersPo.setEncryptLocalTime(LocalDateTime.now());
        ordersPo.setEncryptLocalDate(LocalDate.now());
        iOrdersPoService.updateById(ordersPo);
        return ResponseResult.success(ordersPo);
    }

    @GetMapping("/listUpdate")
    @Operation(summary ="自动加密listUpdate")
    public ResponseResult<List<OrdersPo>> listUpdate(@RequestParam List<Long> ids){
        byte a = -21;
        short b = -4321;
        List<OrdersPo> ordersPo = iOrdersPoService.listByIds(ids);
        for (OrdersPo orders:ordersPo){
            orders.setEncrypt("自动加密listUpdate"+new Date());
            orders.setEncryptBoolean(true);
            orders.setEncryptLong(-987654321L);
            orders.setEncryptInt(-987654321);
            orders.setEncryptBigDecimal(new BigDecimal("-987654321.5"));
            orders.setEncryptDouble(-987654321.123456789);
            orders.setEncryptFloat(-987654321.123456789F);
            orders.setEncryptShort(b);
            orders.setEncryptByte(a);
            orders.setEncryptTime(new Date());
            orders.setEncryptLocalTime(LocalDateTime.now());
            orders.setEncryptLocalDate(LocalDate.now());
        }
        iOrdersPoService.updateBatchById(ordersPo);
        return ResponseResult.success(ordersPo);
    }

    @GetMapping("/listSelectByQw")
    @Operation(summary ="listSelectByQw")
    public ResponseResult<List<OrdersPo>> listSelectByQw(){
        QueryWrapper<OrdersPo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id","1385858927984640");
        queryWrapper.or().eq("order_id","1385858926772224");
        List<OrdersPo> one = iOrdersPoService.list(queryWrapper);
        return ResponseResult.success(one);
    }

    @GetMapping("/selectVO2")
    @Operation(summary ="selectVO2")
    public ResponseResult<List<OrdersPo>> selectVO2(){
        List<OrdersPo> ordersPos = ordersPoMapper.selectVO2();
        return ResponseResult.success(ordersPos);
    }

}

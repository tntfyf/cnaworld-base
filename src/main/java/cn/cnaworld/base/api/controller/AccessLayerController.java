package cn.cnaworld.base.api.controller;


import cn.cnaworld.base.domain.aggregate.order.model.root.Order;
import cn.cnaworld.framework.infrastructure.annotation.CnaAopLog;
import cn.cnaworld.framework.infrastructure.utils.http.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/accessLayer/v1")
@Api(tags = "接入层负责domain领域间协调")
public class AccessLayerController {

    /**
     * 同时查询返回两个Domain下的数据
     * @author Lucifer
     * @date 2023/3/10
     * @since 1.0.0
     * @param studentId String
     * @return ResponseResult<StudentAndTeacherDto>
     */
    @GetMapping("/test/{studentId}")
    @CnaAopLog
    @ApiOperation("查询学生老师数据")
    public ResponseResult<Order> getStudentAndTeacher(@PathVariable String studentId){
        Order order = new Order();
        order.getOrderInfo(Long.valueOf(studentId));
        return ResponseResult.success(order);
    }

}

package cn.cnaworld.base.domain.teacher.controller;


import cn.cnaworld.base.domain.teacher.model.vo.TeacherWithStudentListVo;
import cn.cnaworld.base.domain.teacher.service.ITeacherService;
import cn.cnaworld.framework.infrastructure.utils.http.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 老师接口
 * @author Lucifer
 * @since 2023-03-10
 */
@RestController
@RequestMapping("/teacher")
@Slf4j
@Api(tags = "老师接口")
public class TeacherController {

    @Autowired
    private ITeacherService iTeacherService;

    /**
     * 查询学生列表包含老师数据
     * @param teacherId String
     * @param teacherName String
     * @return ResponseResult<List<TeacherWithStudentListVo>>
     */
    @ApiOperation("查询学生列表包含老师数据")
    @GetMapping("/StudentAndTeacherlist")
    public ResponseResult<List<TeacherWithStudentListVo>> teacherWithStudentList(@RequestParam(required = false) String teacherId, @RequestParam(required = false) String teacherName) {
        //定义查询结果list
        List<TeacherWithStudentListVo> teacherWithStudentList;
        try {
            log.debug("开始查询学生列表包含老师数据,teacherId：{},studentName：{}",teacherId,teacherName);
            teacherWithStudentList = iTeacherService.findTeacherWithStudentList(teacherId,teacherName);
            log.debug("开始查询学生列表包含老师数据成功,teacherId：{},studentName：{}",teacherId,teacherName);
        } catch (Exception e) {
            //查询失败返回打印异常信息
            log.error("开始查询学生列表包含老师数据失败,teacherId：{},studentName：{}",teacherId,teacherName,e);
            return ResponseResult.error("开始查询学生列表包含老师数据失败,请联系管理员确认问题！");
        }
        //查询成功返回结果
        return ResponseResult.success(teacherWithStudentList);
    }

}


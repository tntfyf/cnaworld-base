package cn.cnaworld.base.domain.student.controller;


import cn.cnaworld.base.domain.student.entity.Student;
import cn.cnaworld.base.domain.student.model.dto.StudentWithTeacherlistDto;
import cn.cnaworld.base.domain.student.model.vo.StudentWithTeacherVo;
import cn.cnaworld.base.domain.student.service.IStudentService;
import cn.cnaworld.framework.infrastructure.annotation.CnaAopLog;
import cn.cnaworld.framework.infrastructure.annotation.CnaRedisLock;
import cn.cnaworld.framework.infrastructure.common.ExceptionCallBack;
import cn.cnaworld.framework.infrastructure.statics.LockType;
import cn.cnaworld.framework.infrastructure.utils.CnaLogUtil;
import cn.cnaworld.framework.infrastructure.utils.http.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 学生领域接口
 * @author Lucifer
 * @date 2022-09-27
 */
@RestController
@RequestMapping("/student")
@Api(tags = "学生接口")
@Slf4j
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    /**
     * 查询学生列表
     * @param studentId String
     * @param studentName String
     * @return ResponseResult<List<Student>>
     */
    @ApiOperation("查询学生列表")
    @GetMapping("/list")
    @CnaRedisLock(key = "静态值",prefix = "前缀",lockType = LockType.Lock,paramsAsKey = {"studentId","studentName"},sync = true,waitTime = 10,timeUnit = TimeUnit.SECONDS,exceptionCallBack = ExceptionCallBack.class)
    public ResponseResult<List<Student>> list(@RequestParam(required = false) String studentId, @RequestParam(required = false) String studentName) {
        //定义查询结果list
        List<Student> list;
        try {
            CnaLogUtil.debug(log,"开始查询学生列表,studentId：{},studentName：{}",studentId,studentName);
            QueryWrapper<Student> queryWrapper= new QueryWrapper<>();
            //组织判断条件，不为空则进行查询
            if(StringUtils.isNotBlank(studentId)) {
                queryWrapper.eq("student_id", studentId);
            }
            if(StringUtils.isNotBlank(studentName)) {
                queryWrapper.like("student_name", studentName);
            }
            //调用数据库查询方法
            list = iStudentService.list(queryWrapper);
            CnaLogUtil.debug(log,"查询学生列表成功,studentId：{},studentName：{}",studentId,studentName);
        } catch (Exception e) {
            //查询失败返回打印异常信息
            CnaLogUtil.error(log,"查询学生列表失败,studentId：{},studentName：{}",studentId,studentName,e);
            return ResponseResult.error("查询学生列表失败,请联系管理员确认问题！");
        }
        //查询成功返回结果
        return ResponseResult.success(list);
    }


    /**
     * 查询学生列表包含老师数据
     * @param studentWithTeacherlistDto StudentWithTeacherlistDto
     * @return ResponseResult<List<StudentWithTeacherVo>>
     */
    @ApiOperation("查询学生列表包含老师数据")
    @PostMapping("/StudentAndTeacherlist")
    @CnaAopLog
    @CnaRedisLock(paramsAsKey = "studentWithTeacherlistDto")
    public ResponseResult<List<StudentWithTeacherVo>> studentWithTeacherlist(@RequestBody StudentWithTeacherlistDto studentWithTeacherlistDto) {
        //定义查询结果list
        List<StudentWithTeacherVo> studentWithTeacherVoList;
        try {
            CnaLogUtil.debug(log,"开始查询学生列表包含老师数据,studentId：{},studentName：{},teacherId：{}",studentWithTeacherlistDto.getStudentId(),studentWithTeacherlistDto.getStudentName(),studentWithTeacherlistDto.getTeacherId());
            studentWithTeacherVoList = iStudentService.findStudentWithTeacher(studentWithTeacherlistDto);
            CnaLogUtil.debug(log,"开始查询学生列表包含老师数据成功,studentId：{},studentName：{},teacherId：{}",studentWithTeacherlistDto.getStudentId(),studentWithTeacherlistDto.getStudentName(),studentWithTeacherlistDto.getTeacherId());
        } catch (Exception e) {
            //查询失败返回打印异常信息
            CnaLogUtil.error(log,"开始查询学生列表包含老师数据失败,studentId：{},studentName：{},teacherId：{}",studentWithTeacherlistDto.getStudentId(),studentWithTeacherlistDto.getStudentName(),studentWithTeacherlistDto.getTeacherId(),e);
            return ResponseResult.error("开始查询学生列表包含老师数据失败,请联系管理员确认问题！");
        }
        //查询成功返回结果
        return ResponseResult.success(studentWithTeacherVoList);
    }
}


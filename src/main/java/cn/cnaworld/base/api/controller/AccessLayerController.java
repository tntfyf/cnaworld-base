package cn.cnaworld.base.api.controller;

import cn.cnaworld.base.api.model.dto.StudentAndTeacherDto;
import cn.cnaworld.base.domain.student.controller.StudentController;
import cn.cnaworld.base.domain.student.model.dto.StudentWithTeacherlistDto;
import cn.cnaworld.base.domain.student.model.vo.StudentWithTeacherVo;
import cn.cnaworld.base.domain.teacher.controller.TeacherController;
import cn.cnaworld.base.domain.teacher.model.vo.TeacherWithStudentListVo;
import cn.cnaworld.framework.infrastructure.annotation.CnaAopLog;
import cn.cnaworld.framework.infrastructure.utils.http.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    private StudentController studentController;

    @Autowired
    private TeacherController teacherController;

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
    public ResponseResult<StudentAndTeacherDto> getStudentAndTeacher(@PathVariable String studentId){
        StudentWithTeacherlistDto studentWithTeacherlistDto=new StudentWithTeacherlistDto();
        studentWithTeacherlistDto.setStudentId(Long.valueOf(studentId));
        studentWithTeacherlistDto.setStudentName("张三");
        studentWithTeacherlistDto.setTeacherId(0L);
        ResponseResult<List<StudentWithTeacherVo>> studentWithTeacherVoResponseResult = studentController.studentWithTeacherlist(studentWithTeacherlistDto);
        ResponseResult<List<TeacherWithStudentListVo>> teacherWithStudentListVoResponseResult = teacherController.teacherWithStudentList(studentId,"李四");
        return ResponseResult.success(new StudentAndTeacherDto(studentWithTeacherVoResponseResult.getData(),teacherWithStudentListVoResponseResult.getData()));
    }

}

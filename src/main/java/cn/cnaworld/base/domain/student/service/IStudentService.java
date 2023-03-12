package cn.cnaworld.base.domain.student.service;

import cn.cnaworld.base.domain.student.entity.Student;
import cn.cnaworld.base.domain.student.model.dto.StudentWithTeacherlistDto;
import cn.cnaworld.base.domain.student.model.vo.StudentWithTeacherVo;
import cn.cnaworld.framework.infrastructure.component.mybatisplus.baseclass.service.CnaWorldBaseService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lucifer
 * @since 2023-03-10
 */
public interface IStudentService extends CnaWorldBaseService<Student> {

    /**
     * 查询学生和其老师列表
     * @author Lucifer
     * @date 2023/3/10
     * @since 1.0.0
     * @param studentWithTeacherlistDto StudentWithTeacherlistDto
     * @return List<StudentWithTeacherVo>
     */
    List<StudentWithTeacherVo> findStudentWithTeacher(StudentWithTeacherlistDto studentWithTeacherlistDto);

}

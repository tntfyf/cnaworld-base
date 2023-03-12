package cn.cnaworld.base.domain.student.service.impl;

import cn.cnaworld.base.domain.student.entity.Student;
import cn.cnaworld.base.domain.student.mapper.StudentMapper;
import cn.cnaworld.base.domain.student.model.dto.StudentWithTeacherlistDto;
import cn.cnaworld.base.domain.student.model.vo.StudentWithTeacherVo;
import cn.cnaworld.base.domain.student.service.IStudentService;
import cn.cnaworld.framework.infrastructure.component.mybatisplus.baseclass.service.impl.CnaWorldBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lucifer
 * @since 2023-03-10
 */
@Service
public class StudentServiceImpl extends CnaWorldBaseServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询学生和其老师列表
     * @author Lucifer
     * @date 2023/3/10
     * @since 1.0.0
     * @param studentWithTeacherlistDto StudentWithTeacherlistDto
     * @return List<StudentWithTeacherVo>
     */
    @Override
    public List<StudentWithTeacherVo> findStudentWithTeacher(StudentWithTeacherlistDto studentWithTeacherlistDto) {
        return studentMapper.selectStudentWithTeacher(studentWithTeacherlistDto);
    }

}

package cn.cnaworld.base.domain.teacher.service.impl;

import cn.cnaworld.base.domain.teacher.entity.Teacher;
import cn.cnaworld.base.domain.teacher.mapper.TeacherMapper;
import cn.cnaworld.base.domain.teacher.model.vo.TeacherWithStudentListVo;
import cn.cnaworld.base.domain.teacher.service.ITeacherService;
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
public class TeacherServiceImpl extends CnaWorldBaseServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 查询老师及其学生列表
     * @author Lucifer
     * @date 2023/3/10
     * @since 1.0.0
     * @param teacherId String
     * @param teacherName String
     * @return List<TeacherWithStudentListVo>
     */
    @Override
    public List<TeacherWithStudentListVo> findTeacherWithStudentList(String teacherId, String teacherName) {
        return teacherMapper.selectTeacherWithStudentList(teacherId, teacherName);
    }
}

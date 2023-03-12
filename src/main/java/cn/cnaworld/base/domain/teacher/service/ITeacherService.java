package cn.cnaworld.base.domain.teacher.service;

import cn.cnaworld.base.domain.teacher.entity.Teacher;
import cn.cnaworld.base.domain.teacher.model.vo.TeacherWithStudentListVo;
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
public interface ITeacherService extends CnaWorldBaseService<Teacher> {

    /**
     * 查询老师及其学生列表
     * @author Lucifer
     * @date 2023/3/10
     * @since 1.0.0
     * @param teacherId String
     * @param teacherName String
     * @return List<TeacherWithStudentListVo>
     */
    List<TeacherWithStudentListVo> findTeacherWithStudentList(String teacherId , String teacherName);
}

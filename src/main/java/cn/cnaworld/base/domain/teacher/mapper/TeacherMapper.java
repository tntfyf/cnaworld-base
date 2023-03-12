package cn.cnaworld.base.domain.teacher.mapper;

import cn.cnaworld.base.domain.teacher.entity.Teacher;
import cn.cnaworld.base.domain.teacher.model.vo.TeacherWithStudentListVo;
import cn.cnaworld.framework.infrastructure.component.mybatisplus.baseclass.mapper.CnaWorldBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lucifer
 * @since 2023-03-10
 */
public interface TeacherMapper extends CnaWorldBaseMapper<Teacher> {

    /**
     * 查询老师及其学生列表
     * @author Lucifer
     * @date 2023/3/10
     * @since 1.0.0
     * @param teacherId String
     * @param teacherName String
     * @return List<TeacherWithStudentListVo>
     */
    List<TeacherWithStudentListVo> selectTeacherWithStudentList(@Param(value = "teacherId") String teacherId, @Param(value = "teacherName") String teacherName);
}

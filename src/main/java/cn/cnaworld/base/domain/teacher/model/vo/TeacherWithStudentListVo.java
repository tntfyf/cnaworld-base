package cn.cnaworld.base.domain.teacher.model.vo;

import cn.cnaworld.base.domain.teacher.entity.Teacher;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
/**
 * 老师及其学生列表VO
 * @author Lucifer
 * @date 2023/3/10
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
@ApiModel(value = "TeacherWithStudentListVo对象", description = "")
public class TeacherWithStudentListVo extends Teacher {

    @ApiModelProperty(value = "student集合")
    private List<Student_TeacherWithStudentListVo> studentList;
    
}

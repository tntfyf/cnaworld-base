package cn.cnaworld.base.api.model.dto;

import cn.cnaworld.base.domain.student.model.vo.StudentWithTeacherVo;
import cn.cnaworld.base.domain.teacher.model.vo.TeacherWithStudentListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author Lucifer
 * @date 2023/3/10
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@ApiModel(value = "StudentAndTeacherDto对象", description = "")
public class StudentAndTeacherDto {

  @ApiModelProperty(value = "学生及老师集合")
  private List<StudentWithTeacherVo> studentWithTeacherList;

  @ApiModelProperty(value = "老师及学生集合")
  private List<TeacherWithStudentListVo> teacherWithStudentList;

}

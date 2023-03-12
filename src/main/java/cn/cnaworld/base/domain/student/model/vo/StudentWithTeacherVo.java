package cn.cnaworld.base.domain.student.model.vo;

import cn.cnaworld.base.domain.student.entity.Student;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 学生和其老师VO
 * @author Lucifer
 * @date 2023/3/10
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
public class StudentWithTeacherVo extends Student {
	
	private Teacher_StudentWithTeacherVo teacherVo;

}

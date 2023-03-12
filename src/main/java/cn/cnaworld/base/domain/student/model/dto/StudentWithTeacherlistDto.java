package cn.cnaworld.base.domain.student.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 学生及其老师集合
 * @author Lucifer
 * @date 2023/3/10
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
@ApiModel(value = "StudentWithTeacherlistDto对象", description = "")
public class StudentWithTeacherlistDto {
    @ApiModelProperty(value = "学生ID")
    private Long studentId;
    @ApiModelProperty(value = "学生姓名")
    private String studentName;
    @ApiModelProperty(value = "老师ID")
    private Long teacherId;

}

package cn.cnaworld.base.domain.student.entity;

import cn.cnaworld.base.infrastructure.component.baseclass.CnaWorldBaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lucifer
 * @since 2023-03-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("student")
@ApiModel(value = "Student对象", description = "")
public class Student extends CnaWorldBaseEntity {

    /**
     * 学生ID
     */
    @ApiModelProperty(value = "学生Id")
    @TableId(value = "student_id", type = IdType.ASSIGN_ID)
    private Long studentId;

    /**
     * 学生姓名
     */
    @ApiModelProperty(value = "学生姓名")
    @TableField("student_name")
    private String studentName;

    /**
     * 老师ID
     */
    @ApiModelProperty(value = "老师ID")
    @TableField("teacher_id")
    private Long teacherId;

}

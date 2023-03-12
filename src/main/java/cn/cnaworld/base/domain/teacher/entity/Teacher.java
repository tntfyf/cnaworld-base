package cn.cnaworld.base.domain.teacher.entity;

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
@TableName("teacher")
@ApiModel(value = "Teacher对象", description = "")
public class Teacher extends CnaWorldBaseEntity {

    @ApiModelProperty(value = "老师ID")
    @TableId(value = "teacher_id", type = IdType.ASSIGN_ID)
    private Long teacherId;

    @ApiModelProperty(value = "老师姓名")
    @TableField("teacher_name")
    private String teacherName;

}

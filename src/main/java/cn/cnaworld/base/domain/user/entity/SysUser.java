package cn.cnaworld.base.domain.user.entity;

import cn.cnaworld.base.infrastructure.component.baseclass.CnaWorldBaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lucifer
 * @since 2023-03-28
 */
@EqualsAndHashCode(callSuper = true)
@TableName("sys_user")
@ApiModel(value = "SysUser对象", description = "")
public class SysUser extends CnaWorldBaseEntity implements UserDetails {

    @ApiModelProperty(value = "用户id")
    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private Long userId;

    @ApiModelProperty(value = "用户账号")
    @TableField("user_account")
    private String userAccount;

    @ApiModelProperty(value = "用户名称")
    @TableField("user_name")
    private String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassworld() {
        return userPassworld;
    }

    public void setUserPassworld(String userPassworld) {
        this.userPassworld = userPassworld;
    }

    @ApiModelProperty(value = "用户密码")
    @TableField("user_passworld")
    private String userPassworld;

    @TableField(exist = false)
    private long expireTime;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String getPassword() {
        return userPassworld;
    }

    @Override
    public String getUsername() {
        return userAccount;
    }

    /**
     * 是否账号过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 是否账号被锁定
     *
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 是否凭证（密码）过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}

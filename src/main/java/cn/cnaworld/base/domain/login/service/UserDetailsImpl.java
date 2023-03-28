package cn.cnaworld.base.domain.login.service;

import cn.cnaworld.base.domain.user.entity.SysUser;
import cn.cnaworld.base.domain.user.service.ISysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author Lucifer
 * @date 2023/3/28
 * @since 1.0.0
 */
@Slf4j
@Service
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    private ISysUserService sysUserService;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_account",username);
        SysUser sysUser = sysUserService.getOne(queryWrapper);
        Assert.notNull(sysUser,"用户不存在");
        return sysUser;
    }

}

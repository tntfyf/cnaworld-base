package cn.cnaworld.base.domain.login.controller;

import cn.cnaworld.base.domain.user.entity.SysUser;
import cn.cnaworld.base.domain.user.service.ISysUserService;
import cn.cnaworld.base.infrastructure.utils.jwt.JwtUtil;
import cn.cnaworld.framework.infrastructure.utils.http.ResponseResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接入层，负责domain领域间协调 ，只有Controller 和 service。不与实体直接交互。
 * @author Lucifer
 * @date 2023/2/1
 * @since 1.0
 */
@RestController
@Api(tags = "登录")
public class LoginController {

    @Autowired
    private ISysUserService sysUserService;

    /**
     * index
     * @author Lucifer
     * @date 2023/3/27
     * @since 1.0.0
     */
    @GetMapping("login")
    public ResponseResult<String> index(String username, String password){
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_account",username);
        queryWrapper.eq("user_passworld",password);
        SysUser sysUser = sysUserService.getOne(queryWrapper);
        Assert.notNull(sysUser,"用户不存在");
        return ResponseResult.success("认证成功",JwtUtil.createJwt(sysUser));
    }

}

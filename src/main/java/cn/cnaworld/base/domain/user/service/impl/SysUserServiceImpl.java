package cn.cnaworld.base.domain.user.service.impl;

import cn.cnaworld.base.domain.user.entity.SysUser;
import cn.cnaworld.base.domain.user.mapper.SysUserMapper;
import cn.cnaworld.base.domain.user.service.ISysUserService;
import cn.cnaworld.framework.infrastructure.component.mybatisplus.baseclass.service.impl.CnaWorldBaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lucifer
 * @since 2023-03-28
 */
@Service
public class SysUserServiceImpl extends CnaWorldBaseServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}

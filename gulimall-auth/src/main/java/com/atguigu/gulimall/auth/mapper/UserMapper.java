package com.atguigu.gulimall.auth.mapper;

import com.atguigu.common.pojo.system.SystemUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserMapper extends BaseMapper<SystemUser> {
    SystemUser findByName(String username);
}

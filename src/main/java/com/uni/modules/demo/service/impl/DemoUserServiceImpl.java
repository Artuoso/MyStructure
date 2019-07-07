package com.uni.modules.demo.service.impl;

import com.uni.common.base.service.BaseCrudServiceImpl;
import com.uni.modules.demo.dao.DemoUserMapper;
import com.uni.modules.demo.entity.DemoUser;
import com.uni.modules.demo.service.DemoUserService;
import org.springframework.stereotype.Service;

/**
* @Description 示例service实现类
*
* @author Created by zc on 2019/7/5
*/
@Service
public class DemoUserServiceImpl extends BaseCrudServiceImpl<DemoUserMapper, DemoUser> implements DemoUserService {
}

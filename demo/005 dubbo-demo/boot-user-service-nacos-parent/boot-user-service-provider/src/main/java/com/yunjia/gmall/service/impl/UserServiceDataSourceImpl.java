package com.yunjia.gmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yunjia.gmall.bean.User;
import com.yunjia.gmall.mapper.UserMapper;
import com.yunjia.gmall.service.UserServiceDataSource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDataSourceImpl extends ServiceImpl<UserMapper, User> implements UserServiceDataSource {
}

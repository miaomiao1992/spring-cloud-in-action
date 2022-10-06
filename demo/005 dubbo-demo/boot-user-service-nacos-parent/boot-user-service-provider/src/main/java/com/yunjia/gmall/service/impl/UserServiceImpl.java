package com.yunjia.gmall.service.impl;

import com.yunjia.gmall.service.UserServiceDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import com.yunjia.gmall.bean.User;
import com.yunjia.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service  //暴露服务
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserServiceDataSource userServiceDataSource;

    @Override
    public List<User> getAllUser() throws Exception {
        List<User> users = userServiceDataSource.list();
        return users;
    }

    @Override
    public User getUserById(Long userId) throws Exception {
        //数据库
        System.out.println("getUserById 收到了请求，userId:" + userId);
        User user = userServiceDataSource.getById(userId);
        if (user  == null){
            System.out.println("查询到空对象");
            return null;
        }
        System.out.println("查询到的数据库对象：" + user.toString());
        return user;
    }

    @Override
    public User updateUser(User user) throws Exception {
        boolean ret = userServiceDataSource.updateById(user);
        if (!ret){
            log.info("更新用户信息失败");
            return null;
        }
        return user;
    }

    @Override
    public User saveUser(User user) throws Exception {
        boolean ret = userServiceDataSource.save(user);
        if (!ret){
            log.info("新增用户失败");
            return null;
        }
        return user;
    }

    @Override
    public boolean deleteUser(Long userId) throws Exception {
        System.out.println("userId:" + userId);
        boolean ret = userServiceDataSource.removeById(userId);
        if (!ret){
            log.info("删除失败");
            return false;
        }
        return true;
    }


}

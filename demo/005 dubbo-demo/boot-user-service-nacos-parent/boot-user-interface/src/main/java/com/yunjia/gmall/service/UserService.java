package com.yunjia.gmall.service;

import com.yunjia.gmall.bean.User;

import java.util.List;

public interface UserService {

    /**
     * 获取所有用户信息
     * @return
     * @throws Exception
     */
    public List<User> getAllUser() throws Exception;

    /**
     * 根据用户Id查询用户信息
     * @param userId
     * @return
     */
    public User getUserById(Long userId) throws Exception;

    /**
     * 根据用户Id更新用户信息
     * @param user
     * @return
     * @throws Exception
     */
    public User updateUser(User user) throws Exception;

    /**
     * 新增用户信息
     * @param user
     * @return
     * @throws Exception
     */
    public User saveUser(User user) throws Exception;

    /**
     * 根据用户Id删除用户信息
     * @param userId
     * @return
     * @throws Exception
     */
    public boolean deleteUser(Long userId) throws Exception;
}

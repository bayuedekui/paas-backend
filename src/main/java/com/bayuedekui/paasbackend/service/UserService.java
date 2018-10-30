package com.bayuedekui.paasbackend.service;

import com.bayuedekui.paasbackend.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 获取所有用户信息,可以供管理员使用
     * @return
     */
    List<User> getAllUsers();

    /**
     * 根据用户名获取某一个用户的信息
     * 
     * @return
     */
    User getOneUserByName();

    /**
     * 增加用户
     * @param user
     * @return
     */
    User addOneUser(User user);

    /**
     * 批量增加用户
     * @return
     */
    int addBatchUser(List<User> userList);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateOneUser(User user);

    /**
     * 批量修改用户,用于管理员使用
     * @param user
     * @return
     */
    int updateBatchUser(List<User> user);

    /**
     * 根据用户名删除用户记录,目前注册时遍历数据库表信息,不允许重名(比较弟低效率的方式)
     * @param name
     * @return
     */
    int deleteOneUser(String name);
    
    
}

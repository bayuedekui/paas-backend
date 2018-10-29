package com.bayuedekui.paasbackend.dao;

import com.bayuedekui.paasbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    /**
     * 查询所有用户
     * @return
     */
    @Override
    List<User> findAll();

    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    User findByName(String name);

    
    
}

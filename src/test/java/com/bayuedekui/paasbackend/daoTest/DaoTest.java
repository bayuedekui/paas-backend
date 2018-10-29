package com.bayuedekui.paasbackend.daoTest;

import com.bayuedekui.paasbackend.dao.UserRepository;
import com.bayuedekui.paasbackend.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoTest {
    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void testQueryUsers(){
        List<User> all = userRepository.findAll();
        for(User user : all){
            System.out.println(user.toString());
        }
    }
    
    @Test
    public void testInsertUser(){
        User user=new User();
        user.setName("liuwenchang");
        user.setPassword("123");
        user.setEmail("3");
        User save = userRepository.save(user);
        System.out.println(save.toString());
    }
    
    @Test
    public void testUpdateUser(){
        User shenshuting = userRepository.findByName("shenshuting");
        shenshuting.setEmail("8468");
        userRepository.save(shenshuting);
    }
    
}

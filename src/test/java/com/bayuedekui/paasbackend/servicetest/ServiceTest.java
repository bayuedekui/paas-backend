package com.bayuedekui.paasbackend.servicetest;

import com.bayuedekui.paasbackend.entity.User;
import com.bayuedekui.paasbackend.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceTest {
    
    @Autowired
    private UserService userService;
    
    @Test
    public void testGetOneUserByName(){
        User zhengkui =  userService.getOneUserByName("zhengkui");
        System.out.println(zhengkui.toString());
    }
}

package com.bayuedekui.paasbackend.service.serviceImpl;

import com.bayuedekui.paasbackend.dao.UserRepository;
import com.bayuedekui.paasbackend.entity.User;
import com.bayuedekui.paasbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getOneUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User addOneUser(User user) {
        
        return userRepository.save(user);
    }

    @Override
    public int addBatchUser(List<User> userList) {
        return 0;
    }

    @Override
    public int updateOneUser(User user) {
        return 0;
    }

    @Override
    public int updateBatchUser(List<User> user) {
        return 0;
    }

    @Override
    public int deleteOneUser(String name) {
        return 0;
    }
}

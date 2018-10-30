package com.bayuedekui.paasbackend.controller;

import com.bayuedekui.paasbackend.dao.UserRepository;
import com.bayuedekui.paasbackend.entity.User;
import com.bayuedekui.paasbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registory", method = RequestMethod.POST)
    public Map<String, Object> registerUser(@RequestBody User user, HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        user.setCreate_time(new Date());
        try {
            User user1 = userService.addOneUser(user);
            if (user1 != null) {
                modelMap.put("success", true);
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", "registory failed");
            }

        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }


    @RequestMapping(value = "/allusers",method =RequestMethod.GET )
    public Map<String, Object> getALlUsers(HttpServletRequest requeset) {
        Map<String, Object> modelMap = new HashMap<>();
        try {
            List<User> allUsers = userService.getAllUsers();
            if (allUsers.size() > 0) {
                modelMap.put("success", true);
                modelMap.put("userList", allUsers);
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", "no user");
            }
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }
}

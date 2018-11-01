package com.bayuedekui.paasbackend.controller;

import com.bayuedekui.paasbackend.entity.User;
import com.bayuedekui.paasbackend.service.UserService;
import com.bayuedekui.paasbackend.utils.HttpServletRequestUtil;
import com.bayuedekui.paasbackend.utils.PswMD5Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/registory")
    public Map<String, Object> registerUser(HttpServletRequest request) throws IOException, NoSuchAlgorithmException {
        Map<String, Object> modelMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        String userStr = HttpServletRequestUtil.getString(request,"userStr");
        User user=null;
        user = mapper.readValue(userStr, User.class);
        user.setPassword(PswMD5Util.EncoderByMd5(user.getPassword()));
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


    @GetMapping(path = "/allusers")
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
    
    @PostMapping(path = "/login")
    public Map<String,Object> vertifyLogin(HttpServletRequest request) throws IOException, NoSuchAlgorithmException {
        Map<String, Object> modelMap = new HashMap<>();
        String loginUser = HttpServletRequestUtil.getString(request, "loginUser");
        ObjectMapper mapper = new ObjectMapper();
        User user=null;
        user = mapper.readValue(loginUser, User.class);
        User oneUser = userService.getOneUserByName(user.getName());
        if(PswMD5Util.EncoderByMd5(user.getPassword()) ==oneUser.getPassword()){
            modelMap.put("success", true);
            modelMap.put("user", user);
        }else{
            modelMap.put("success", false);
            modelMap.put("errMsg", "password error");
        }

        return modelMap;
    }
}

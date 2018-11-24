package com.bayuedekui.paasbackend.controller;

import com.bayuedekui.paasbackend.entity.User;
import com.bayuedekui.paasbackend.service.UserService;
import com.bayuedekui.paasbackend.utils.HttpServletRequestUtil;
import com.bayuedekui.paasbackend.utils.PswMD5Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import org.json.HTTP;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.DataInput;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param userInfo
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Map<String, Object> registerUser(User userInfo) throws IOException, NoSuchAlgorithmException {
        Map<String, Object> modelMap = new HashMap<>();
        String pswMd5=PswMD5Util.EncoderByMd5(userInfo.getPassword());
        userInfo.setPassword(pswMd5);
        try {
            User user1 = userService.addOneUser(userInfo);
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

    /**
     * 用户登陆验证
     * @param userInfo
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,Object> userLogin(User userInfo,HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        User userInDB = userService.getOneUserByName(userInfo.getName());
        String inputPswMd5 = PswMD5Util.EncoderByMd5(userInfo.getPassword());

        Map<String, Object> modelMap = new HashMap<>();
        if(inputPswMd5.equals(userInDB.getPassword())){    //不能用==,比较的是地址,要用equals
            modelMap.put("success",true);
            modelMap.put("user", userInfo);
            request.getSession().setAttribute("userInfo",userInfo);
        }
        return modelMap;
    }

    /**
     * 查询session中有无用户登录信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/loginedperson",method = RequestMethod.GET)
    public Map<String,Object> getUserSession(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<>();
        User userInfo = (User) request.getSession().getAttribute("userInfo");
        
        if(userInfo!=null){
            modelMap.put("isLogined", true);
            modelMap.put("username", userInfo.getName());
        }else{
            modelMap.put("isLogined", false);
        }
        
        return modelMap;
    }
    
    @RequestMapping(value = "/exit",method = RequestMethod.GET)
    public boolean isExit(HttpServletRequest request){
        if(request.getSession().getAttribute("userInfo")!=null){
            request.getSession().invalidate();
            return true;
        }
        return true;
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
    
}

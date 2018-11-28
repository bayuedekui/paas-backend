package com.bayuedekui.paasbackend.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Test {

    @GetMapping("/info")
    @ResponseBody
    public String getDockerInfo(){
        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> response = rest.exchange("http://192.168.172.134:2375/containers/json", HttpMethod.GET, null, String.class);
        System.out.println(response.getBody().toString());
        return  response.getBody().toString();
    }
}

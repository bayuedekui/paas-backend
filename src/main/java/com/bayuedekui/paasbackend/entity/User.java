package com.bayuedekui.paasbackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "t_user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="sex")
    private int sex;    //0表示女生,1表示男生

    @Column(name="role")
    private int role;   //角色0普通用户,1服务发布者,2平台管理员
    
    @Column(name="motto")
    private String motto;

    @Column(name="create_time")
    private Date create_time;

    @Column(name="last_edit_time")
    private Date last_edit_time;
}

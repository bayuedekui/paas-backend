create database paas default character set utf8 collate utf8_general_ci;

use paas;
create table t_user(
  id              int(11)  not null primary key auto_increment,
  name            varchar(255)  not null,
  password        varchar(255)  not null,
  email           varchar(255)  not null,
  sex             int(2),
  role            int(2),   
  motto           varchar(255),
  create_time     datetime,
  last_edit_time  datetime  
)engine=InnoDB default charset=utf8 comment='用户表'; 

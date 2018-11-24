package com.bayuedekui.paasbackend.entity;

import lombok.Data;

@Data
public class RespEntity {
    private String status;
    private String errMsg;
    
    public RespEntity(String status,String errMsg){
        this.status=status;
        this.errMsg=errMsg;
    }
}

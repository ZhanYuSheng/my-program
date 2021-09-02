package com.example.web.bean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class User implements Serializable {

    private Long id;

    private String userName;

    private String passWord;

    private Date createTime;

    private Date modifyTime;

}

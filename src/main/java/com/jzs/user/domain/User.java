package com.jzs.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * Created by jiangzs@gmail.com on 2017/3/21.
 */
@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer uid;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String mobile;
    private String sex;
    private Date createTime;
    private Date lastUpdateTime;

}


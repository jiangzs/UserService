package com.jzs.user.service.impl;

import com.jzs.user.dao.UserDao;
import com.jzs.user.dto.UserProtos;
import com.jzs.user.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.jzs.user.domain.User;
import com.jzs.user.dto.UserConverters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiangzs@gmail.com on 2017/3/21.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    @HystrixCommand(fallbackMethod = "queryUserByUidDefault")
    public UserProtos.UserDTO queryUserByUid(Integer uid) {
        log.info("uid:{}",uid);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
////            e.printStackTrace();
//        }
        User user =  dao.queryByUid(uid);
        return UserConverters.asDTO(user);
    }

    public UserProtos.UserDTO queryUserByUidDefault(Integer uid) {
        log.info("queryUserByUidDefault uid:{}",uid);
        return UserProtos.UserDTO.newBuilder().build();
    }


}

package com.jzs.user.service;

import com.jzs.user.dto.UserProtos;

/**
 * Created by jiangzs@gmail.com on 2017/3/21.
 */
public interface UserService {

    UserProtos.UserDTO queryUserByUid(Integer uid);

}

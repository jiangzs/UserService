package com.jzs.user.dao;

import com.jzs.user.domain.User;

/**
 * Created by jiangzs@gmail.com on 2017/3/21.
 */
public interface UserDao {

    User queryByUid(Integer uid);
}

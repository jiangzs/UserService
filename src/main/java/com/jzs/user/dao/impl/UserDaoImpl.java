package com.jzs.user.dao.impl;

import com.jzs.user.dao.UserDao;
import com.jzs.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by jiangzs@gmail.com on 2017/3/21.
 */
@Component
@Slf4j
public class UserDaoImpl implements UserDao {

    @Override
    public User queryByUid(Integer uid) {
        log.info("queryByUid:{}", uid);
        User u = new User();
        if (uid < 10) {
            u.setUid(uid);
            u.setFirstName("firstName");
            u.setLastName("lastName");
            u.setBirthDay(new Date());
            u.setCreateTime(new Date());
            u.setLastUpdateTime(new Date());
            u.setSex("man");
            return u;
        }

        return null;
    }
}

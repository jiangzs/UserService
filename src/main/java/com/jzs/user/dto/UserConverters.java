package com.jzs.user.dto;

import com.jzs.user.domain.User;
import com.jzs.utils.DateUtils;

/**
 * Created by jiangzs@gmail.com on 2017/3/21.
 */
public final class UserConverters {
    public static UserProtos.UserDTO  asDTO(User user){
        if (user!=null){
             return UserProtos.UserDTO.newBuilder()
                    .setSex(user.getSex())
                    .setLastName(user.getLastName())
                    .setBirthDay(DateUtils.to(user.getBirthDay(),"yyyy-MM-dd"))
                    .setFirstName(user.getFirstName())
                    .setLastName(user.getLastName())
//                    .setMobile(user.getMobile())
                     .build();
        }
        return null;
    }

    public static User  asDomain(UserProtos.UserDTO user){
        if (user!=null){
            User domain = new User();
            domain.setMobile(user.getMobile());
            //TODO ...
            return domain;
        }
        return null;
    }
}

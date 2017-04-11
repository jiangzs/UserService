package com.jzs.user.client;

import com.jzs.user.domain.User1;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jiangzs@gmail.com on 2017/4/7.
 */
@FeignClient(value = "AUTHSERVER")
public interface AuthServiceClient {

    @RequestMapping(method = RequestMethod.POST, value = "/uaa/users/create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void createUser(User1 user);

}

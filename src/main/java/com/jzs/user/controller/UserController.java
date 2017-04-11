package com.jzs.user.controller;

import com.jzs.user.client.OrderServiceFeign;
import com.jzs.user.domain.Account;
import com.jzs.user.domain.User1;
import com.jzs.user.dto.UserProtos;
import com.jzs.user.service.AccountService;
import com.jzs.user.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by jiangzs@gmail.com on 2017/3/21.
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private AccountService accountService;

    @PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
    @RequestMapping(path = "/{name}", method = RequestMethod.GET)
    public Account getAccountByName(@PathVariable String name) {
        log.info("getAccountByName");
        log.info("OrderServiceFeign {}",orderServiceFeign.home());
        return accountService.findByName(name);
    }

    @RequestMapping(path = "/current", method = RequestMethod.GET)
    public Account getCurrentAccount(Principal principal) {
        return accountService.findByName(principal.getName());
    }

    @RequestMapping(path = "/current", method = RequestMethod.PUT)
    public void saveCurrentAccount(Principal principal, @Valid @RequestBody Account account) {
        accountService.saveChanges(principal.getName(), account);
    }

    @RequestMapping(path = "/abc", method = RequestMethod.POST)
    public Account createNewAccount(@Valid @RequestBody User1 user) {
        log.info("createNewAccount {}",user.toString());
        return accountService.create(user);
    }

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        log.info("home");
        log.info("OrderServiceFeign {}",orderServiceFeign.home());
        return "home";
    }

    @Autowired
    OrderServiceFeign orderServiceFeign;


    @GetMapping("/user/{uid}")
    @HystrixCommand
    public UserProtos.UserDTO queryUserByUid(@PathVariable("uid") Integer uid) {
        log.debug("This is a debug message");
        log.info("This is an info message");
        log.warn("This is a warn message");
        log.error("This is an error message");

        log.info("uid:{}", uid);
        return userService.queryUserByUid(uid);
    }
}

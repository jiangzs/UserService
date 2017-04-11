package com.jzs.user.service;

import com.jzs.user.domain.Account;
import com.jzs.user.domain.User1;

/**
 * Created by jiangzs@gmail.com on 2017/4/7.
 */
public interface AccountService {
    /**
     * Finds account by given name
     *
     * @param accountName
     * @return found account
     */
    Account findByName(String accountName);

    /**
     * Checks if account with the same name already exists
     * Invokes Auth Service user creation
     * Creates new account with default parameters
     *
     * @param user
     * @return created account
     */
    Account create(User1 user);

    /**
     * Validates and applies incoming account updates
     * Invokes Statistics Service update
     *
     * @param name
     * @param update
     */
    void saveChanges(String name, Account update);
}

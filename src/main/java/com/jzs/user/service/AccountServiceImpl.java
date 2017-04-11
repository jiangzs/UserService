package com.jzs.user.service;

import com.jzs.user.client.AuthServiceClient;
import com.jzs.user.domain.Account;
import com.jzs.user.domain.Currency;
import com.jzs.user.domain.Saving;
import com.jzs.user.domain.User1;
import com.jzs.user.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jiangzs@gmail.com on 2017/4/7.
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthServiceClient authClient;

    @Autowired
    private AccountRepository repository;

    /**
     * Finds account by given name
     *
     * @param accountName
     * @return found account
     */
    @Override
    public Account findByName(String accountName) {
        Assert.hasText(accountName);
        return repository.findByName(accountName);
    }

    /**
     * Checks if account with the same name already exists
     * Invokes Auth Service user creation
     * Creates new account with default parameters
     *
     * @param user
     * @return created account
     */
    @Override
    public Account create(User1 user) {
        Account existing = repository.findByName(user.getUsername());
        Assert.isNull(existing, "account already exists: " + user.getUsername());

        authClient.createUser(user);

        Saving saving = new Saving();
        saving.setAmount(new BigDecimal(0));
        saving.setCurrency(Currency.getDefault());
        saving.setInterest(new BigDecimal(0));
        saving.setDeposit(false);
        saving.setCapitalization(false);

        Account account = new Account();
        account.setName(user.getUsername());
        account.setLastSeen(new Date());
        account.setSaving(saving);

        repository.save(account);

        log.info("new account has been created: " + account.getName());

        return account;
    }

    /**
     * Validates and applies incoming account updates
     * Invokes Statistics Service update
     *
     * @param name
     * @param update
     */
    @Override
    public void saveChanges(String name, Account update) {

    }
}

package com.jzs.user.repository;

import com.jzs.user.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jiangzs@gmail.com on 2017/4/7.
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, String> {
    Account findByName(String name);
}

package service;

import domain.Account;
import java.util.List;

/**
 * 账号业务接口
 */
public interface IAccountService {
    List<Account> findAll();

    void update(Account account);

    Account findByName(String name);

    /**
     * a 向 b 转账 money
     * @param a
     * @param b
     * @param money
     */
    void transfer(String a, String b, float money);
}

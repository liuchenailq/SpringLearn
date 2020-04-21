package dao;

import domain.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> findAll();

    void update(Account account);

    Account findByName(String name);
}

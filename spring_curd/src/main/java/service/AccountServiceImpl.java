package service;

import dao.IAccountDao;
import domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    @Qualifier("accountDao")
    private IAccountDao accountDao;

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public Account findByName(String name) {
        return accountDao.findByName(name);
    }

    public void transfer(String a, String b, float money) {
        Account source = accountDao.findByName(a);
        Account target = accountDao.findByName(b);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountDao.update(source);
        int i = 1 / 0;  // 模拟转账失败
        accountDao.update(target);
    }
}

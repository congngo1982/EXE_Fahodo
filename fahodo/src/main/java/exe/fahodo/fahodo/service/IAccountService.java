package exe.fahodo.fahodo.service;

import exe.fahodo.fahodo.entity.Account;

import java.util.List;

public interface IAccountService {
    public List<Account> GetAllAccount();
    public Account GetAccountByUsername(String username);
    public Account CreateAccount(Account account);
}

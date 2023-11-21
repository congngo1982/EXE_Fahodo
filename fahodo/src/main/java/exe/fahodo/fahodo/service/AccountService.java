package exe.fahodo.fahodo.service;

import exe.fahodo.fahodo.entity.Account;
import exe.fahodo.fahodo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<Account> GetAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Account GetAccountByUsername(String username) {
        try{
            return accountRepository.findById(username).get();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Account CreateAccount(Account account) {
        return accountRepository.save(account);
    }
}

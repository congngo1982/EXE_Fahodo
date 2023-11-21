package exe.fahodo.fahodo.controller;

import exe.fahodo.fahodo.entity.Account;
import exe.fahodo.fahodo.security.Bcrypt;
import exe.fahodo.fahodo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountRestController {
    @Autowired
    private IAccountService accountService;

    @PostMapping("/create")
    public Account CreateAccount(@RequestBody Account account) throws Exception {
        if (accountService.GetAccountByUsername(account.getUsername()) != null) {
            throw new Exception("Account is Existed");
        }
        Account account1 = null;
        account.setPassword(Bcrypt.hashPassword(account.getPassword()));
        try {
            account1 = accountService.CreateAccount(account);
        } catch (Exception e) {

        }
        return account1;
    }

    @GetMapping("/authentication")
    public String Authen(Authentication authentication) {
        if (authentication == null) {
            return "";
        }
        String username = authentication.getName();
        if (authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))) {
            return username + "-ADMIN";
        } else if (authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_STORE"))) {
            return username + "-STORE";
        } else if (authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_CUSTOMER"))) {
            return username + "-CUSTOMER";
        }
        return "";
    }

    @GetMapping("/{id}")
    public Account GetAccount(Authentication authentication, @PathVariable String id) {
        Account account = null;
        try {
            account = accountService.GetAccountByUsername(authentication.getName());
        } catch (Exception e) {

        }
        return account;
    }
    @PostMapping("/update")
    public Account UpdateAccount(@RequestBody Account account) throws Exception {
        if (accountService.GetAccountByUsername(account.getUsername()) == null) {
            throw new Exception("Account is not Existed");
        }
        Account account1 = null;
        account.setPassword(Bcrypt.hashPassword(account.getPassword()));
        try {
            account1 = accountService.CreateAccount(account);
        } catch (Exception e) {

        }
        return account1;
    }
}

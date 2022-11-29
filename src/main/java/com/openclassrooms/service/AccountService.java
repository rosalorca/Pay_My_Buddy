package com.openclassrooms.service;

import com.openclassrooms.model.Account;
import com.openclassrooms.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Iterable<Account> getAccounts(){
        return accountRepository.findAll();
    }
    public Optional<Account> getAccountsById (Integer id){
        return accountRepository.findById(id);
    }
    public Account saveAccount (Account account){
        return accountRepository.save(account);
    }
    public void deleteAccountById (Integer id){
        accountRepository.deleteById(id);
    }
  /*  public void addAccount(Account account) {
        accounts.add(account);
        account.getOperations().add(this);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        account.getOperations().remove(this);
    }*/
}

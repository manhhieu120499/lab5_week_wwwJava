package iuh.fit.vomanhhieu_21097401_lab5week.backend.services.account;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Account;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public boolean save(Account T) {
        try{
            accountRepository.save(T);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public boolean update(Account T) {
        return false;
    }

    @Override
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Page<Account> findPaging(int pageNo, int pageSize, String sortBy, String sortDirection) {
        return null;
    }

    @Override
    public Optional<Account> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Account findAccountByUsernameAndPassword(String username, String password) {
        return accountRepository.findAccountByUsernameAndPassword(username, password);
    }
}

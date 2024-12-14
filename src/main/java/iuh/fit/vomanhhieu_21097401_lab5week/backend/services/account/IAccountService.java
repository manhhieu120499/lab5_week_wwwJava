package iuh.fit.vomanhhieu_21097401_lab5week.backend.services.account;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Account;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.IService;

public interface IAccountService extends IService<Account, Long> {
    public Account findAccountByUsernameAndPassword(String username, String password);
}

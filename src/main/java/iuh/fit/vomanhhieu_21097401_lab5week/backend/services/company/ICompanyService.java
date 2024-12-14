package iuh.fit.vomanhhieu_21097401_lab5week.backend.services.company;


import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Company;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.IService;

public interface ICompanyService extends IService<Company, Long> {
    public Company findCompanyByAccountId(Long aLong);
    public Company findCompanyByName(String name);
}

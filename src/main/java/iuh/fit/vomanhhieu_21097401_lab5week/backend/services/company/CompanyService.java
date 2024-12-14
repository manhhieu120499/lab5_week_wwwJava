package iuh.fit.vomanhhieu_21097401_lab5week.backend.services.company;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Company;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public boolean save(Company T) {
        return false;
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public boolean update(Company T) {
        return false;
    }

    @Override
    public Iterable<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Page<Company> findPaging(int pageNo, int pageSize, String sortBy, String sortDirection) {
        return null;
    }

    @Override
    public Optional<Company> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Company findCompanyByAccountId(Long aLong) {
        return companyRepository.findCompanyByAccountId(aLong);
    }

    @Override
    public Company findCompanyByName(String name) {
        return companyRepository.findCompanyByCompName(name);
    }


}

package iuh.fit.vomanhhieu_21097401_lab5week.backend.services.address;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Address;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService implements IAddressService{
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public boolean save(Address T) {
        try{
            addressRepository.save(T);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Long aLong) {
        return addressRepository.deleteAddressById(aLong);
    }

    @Override
    public boolean update(Address T) {
        return false;
    }

    @Override
    public Iterable<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Page<Address> findPaging(int pageNo, int pageSize, String sortBy,
                                    String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return addressRepository.findAll(pageable);
    }

    @Override
    public Optional<Address> findById(Long aLong) {
        return Optional.of(addressRepository.findAddressById(aLong));
    }
}

package iuh.fit.vomanhhieu_21097401_lab5week.backend.services;

import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IService<T,ID> {
    boolean save(T T);
    boolean delete(ID id);
    boolean update(T T);
    Iterable<T> findAll();
    Page<T> findPaging(int pageNo, int pageSize, String sortBy,
                       String sortDirection);
    Optional<T> findById(ID id);
}

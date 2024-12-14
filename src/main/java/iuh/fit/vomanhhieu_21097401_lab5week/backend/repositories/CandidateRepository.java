package iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Candidate findCandidateById(Long id);
    Candidate findCandidateByAccount_Id(Long id);
    boolean removeCandidateById(Long id);

}
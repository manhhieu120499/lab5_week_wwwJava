package iuh.fit.vomanhhieu_21097401_lab5week.backend.services.candidate;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Candidate;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.CandidateSkill;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories.CandidateRepository;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories.CandidateSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CandidateService implements ICandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    @Override
    public boolean save(Candidate T) {
        try{
            candidateRepository.save(T);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Long aLong) {
        return candidateRepository.removeCandidateById(aLong);
    }

    @Override
    public boolean update(Candidate T) {
        return true;
    }

    @Override
    public Iterable<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Page<Candidate> findPaging(int pageNo, int pageSize, String sortBy,
                                      String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return candidateRepository.findAll(pageable);
    }

    @Override
    public Optional<Candidate> findById(Long aLong) {
        return Optional.of(candidateRepository.findCandidateById(aLong));
    }


    @Override
    public Candidate findCandidateByAccountId(Long aLong) {
        return candidateRepository.findCandidateByAccount_Id(aLong);
    }

    @Override
    public List<Long> findSkillOfCandidate(Long aLong) {
        List<CandidateSkill> ds = candidateSkillRepository.findCandidateSkillById_CanId(aLong);
        List<Long> dsSkillId = new ArrayList<>();
        for(CandidateSkill c : ds) {
            dsSkillId.add(c.getSkill().getId());
        }
        return dsSkillId;
    }
}

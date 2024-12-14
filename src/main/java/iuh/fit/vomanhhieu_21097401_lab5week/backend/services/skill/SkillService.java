package iuh.fit.vomanhhieu_21097401_lab5week.backend.services.skill;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.enums.SkillLevel;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.CandidateSkill;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Skill;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories.CandidateSkillRepository;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SkillService implements ISkillService{
    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    @Override
    public boolean save(Skill T) {
        return false;
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public boolean update(Skill T) {
        return false;
    }

    @Override
    public Iterable<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public Page<Skill> findPaging(int pageNo, int pageSize, String sortBy, String sortDirection) {
        return null;
    }

    @Override
    public Optional<Skill> findById(Long aLong) {
        return Optional.of(skillRepository.findSkillById(aLong));
    }

    @Override
    public Skill findSkillById(Long id) {
        return skillRepository.findSkillById(id);
    }

    @Override
    public List<Skill> findSkillBelongToJob(Long id) {
        return skillRepository.findSkillsByJobId(id);
    }

    @Override
    public Skill findSkillBySkillName(String skillName) {
        return skillRepository.findSkillBySkillName(skillName);
    }

    @Override
    public Map<Skill, SkillLevel> findSkillsBeLongToCandidate(Long candidateId) {
        List<CandidateSkill> dsCandidateSkill = candidateSkillRepository.findCandidateSkillById_CanId(candidateId);
        Map<Skill, SkillLevel> skillsBeLongToCandidate = new HashMap<>();
        dsCandidateSkill.forEach(candidateSkill -> {
            Skill s = skillRepository.findSkillById(candidateSkill.getSkill().getId());
            skillsBeLongToCandidate.put(s, candidateSkill.getSkillLevel());
        });
        return skillsBeLongToCandidate;
    }
}

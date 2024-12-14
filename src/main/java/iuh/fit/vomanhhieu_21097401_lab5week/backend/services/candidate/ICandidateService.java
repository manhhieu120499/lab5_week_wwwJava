package iuh.fit.vomanhhieu_21097401_lab5week.backend.services.candidate;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Candidate;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.IService;

import java.util.List;

public interface ICandidateService extends IService<Candidate, Long> {
    public Candidate findCandidateByAccountId(Long aLong);
    public List<Long> findSkillOfCandidate(Long aLong);
}

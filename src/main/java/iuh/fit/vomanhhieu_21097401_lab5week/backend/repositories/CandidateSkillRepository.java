package iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Candidate;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.CandidateSkill;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.CandidateSkillId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillId> {
    List<CandidateSkill> findCandidateSkillById_CanId(Long id);
}
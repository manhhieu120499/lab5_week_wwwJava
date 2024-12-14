package iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.JobSkill;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.JobSkillId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillId> {
    @Modifying
    @Transactional
    void deleteJobsSkillByJob_Id(Long id);

    JobSkill findJobSkillBySkill_IdAndJob_Id(Long skillId, Long jobId);

    @Modifying
    @Transactional
    void deleteJobsSkillByJob_IdAndSkill_Id(Long jobId, Long skillId);
}
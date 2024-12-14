package iuh.fit.vomanhhieu_21097401_lab5week.backend.services.job_skill;


import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.JobSkill;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.JobSkillId;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.IService;

public interface IJobSkillService extends IService<JobSkill, JobSkillId> {
    public boolean deleteJobSkillByJob_Id(Long jobId);
    public JobSkill findJobSkillBySkillIdAndJobId(Long skillId, Long jobId);
    public void deleteJobsSkillByJob_IdAndSkill_Id(Long jobId, Long skillId);
}

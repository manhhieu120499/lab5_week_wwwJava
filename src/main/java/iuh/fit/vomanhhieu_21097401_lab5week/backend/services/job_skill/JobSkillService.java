package iuh.fit.vomanhhieu_21097401_lab5week.backend.services.job_skill;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.JobSkill;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.JobSkillId;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories.JobSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobSkillService implements IJobSkillService {
    @Autowired
    private JobSkillRepository jobSkillRepository;
    @Override
    public boolean save(JobSkill T) {
        try{
            jobSkillRepository.save(T);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(JobSkillId jobSkillId) {
       return false;
    }

    @Override
    public boolean update(JobSkill T) {
        return false;
    }

    @Override
    public Iterable<JobSkill> findAll() {
        return null;
    }

    @Override
    public Page<JobSkill> findPaging(int pageNo, int pageSize, String sortBy, String sortDirection) {
        return null;
    }

    @Override
    public Optional<JobSkill> findById(JobSkillId jobSkillId) {
        return Optional.empty();
    }

    @Override
    public boolean deleteJobSkillByJob_Id(Long jobId) {
        try{
            jobSkillRepository.deleteJobsSkillByJob_Id(jobId);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public JobSkill findJobSkillBySkillIdAndJobId(Long skillId, Long jobId) {
        return jobSkillRepository.findJobSkillBySkill_IdAndJob_Id(skillId, jobId);
    }

    @Override
    public void deleteJobsSkillByJob_IdAndSkill_Id(Long jobId, Long skillId) {
        try{
            jobSkillRepository.deleteJobsSkillByJob_IdAndSkill_Id(jobId, skillId);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}

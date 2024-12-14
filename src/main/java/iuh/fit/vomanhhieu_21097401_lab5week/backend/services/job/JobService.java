package iuh.fit.vomanhhieu_21097401_lab5week.backend.services.job;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Job;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories.JobRepository;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories.JobSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService implements IJobService{
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobSkillRepository jobSkillRepository;
    @Override
    public boolean save(Job T) {
        try{
            jobRepository.save(T);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Long aLong) {
        try{
            jobSkillRepository.deleteJobsSkillByJob_Id(aLong);
            jobRepository.deleteJobById(aLong);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean update(Job T) {
        try{
            jobRepository.save(T);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public Iterable<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Page<Job> findPaging(int pageNo, int pageSize, String sortBy, String sortDirection) {
        return null;
    }

    @Override
    public Optional<Job> findById(Long aLong) {
        return Optional.of(jobRepository.findJobById(aLong));
    }

    @Override
    public List<Job> findJobByCompanyName(String companyName) {
        return jobRepository.findJobsByCompany_CompName(companyName);
    }

    @Override
    public List<Job> findJobForComfortableSkill(Long along) {
        return jobRepository.findJobComfortableSkill(along);
    }
}

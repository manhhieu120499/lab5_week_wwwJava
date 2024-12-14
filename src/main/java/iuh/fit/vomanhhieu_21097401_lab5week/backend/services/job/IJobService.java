package iuh.fit.vomanhhieu_21097401_lab5week.backend.services.job;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Job;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.IService;

import java.util.List;

public interface IJobService extends IService<Job, Long> {
    public List<Job> findJobByCompanyName(String companyName);
    public List<Job> findJobForComfortableSkill(Long along);
}

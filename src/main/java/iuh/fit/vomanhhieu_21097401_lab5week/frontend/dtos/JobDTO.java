package iuh.fit.vomanhhieu_21097401_lab5week.frontend.dtos;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Job;

import java.util.List;

public class JobDTO {
    private String jobId;
    private String jobName;
    private String jobDes;
    private List<SkillUpdateDTO> skills;

    public JobDTO() {}

    public JobDTO(String jobId, String jobName, String jobDes, List<SkillUpdateDTO> skills) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobDes = jobDes;
        this.skills = skills;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDes() {
        return jobDes;
    }

    public void setJobDes(String jobDes) {
        this.jobDes = jobDes;
    }

    public List<SkillUpdateDTO> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillUpdateDTO> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "JobDTO{" +
                "jobId='" + jobId + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobDes='" + jobDes + '\'' +
                ", skills=" + skills +
                '}';
    }
}

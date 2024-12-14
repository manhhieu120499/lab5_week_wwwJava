package iuh.fit.vomanhhieu_21097401_lab5week.backend.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", nullable = false)
    private Long id;

    @Column(name = "job_desc", nullable = false, length = 2000)
    private String jobDesc;

    @Column(name = "job_name", nullable = false)
    private String jobName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company")
    private Company company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Job(){}

    public Job(Long id, String jobDesc, String jobName, Company company) {
        this.id = id;
        this.jobDesc = jobDesc;
        this.jobName = jobName;
        this.company = company;
    }

    public Job(String jobDesc, String jobName, Company company) {
        this.jobDesc = jobDesc;
        this.jobName = jobName;
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobDesc='" + jobDesc + '\'' +
                ", jobName='" + jobName + '\'' +
                ", company=" + company +
                '}';
    }
}
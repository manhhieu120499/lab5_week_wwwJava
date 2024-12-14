package iuh.fit.vomanhhieu_21097401_lab5week.backend.models;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.converters.SkillLevelConverter;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.enums.SkillLevel;
import jakarta.persistence.*;

@Entity
@Table(name = "job_skill")
public class JobSkill {
    @EmbeddedId
    private JobSkillId id;

    @MapsId("jobId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @MapsId("skillId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Column(name = "more_infos", length = 1000)
    private String moreInfos;

    @Convert(converter = SkillLevelConverter.class)
    @Column(name = "skill_level", nullable = false)
    private SkillLevel skillLevel;

    public JobSkillId getId() {
        return id;
    }

    public void setId(JobSkillId id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getMoreInfos() {
        return moreInfos;
    }

    public void setMoreInfos(String moreInfos) {
        this.moreInfos = moreInfos;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    public JobSkill(){}

    public JobSkill(JobSkillId id, Job job, Skill skill, String moreInfos, SkillLevel skillLevel) {
        this.id = id;
        this.job = job;
        this.skill = skill;
        this.moreInfos = moreInfos;
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return "JobSkill{" +
                "id=" + id +
                ", job=" + job +
                ", skill=" + skill +
                ", moreInfos='" + moreInfos + '\'' +
                ", skillLevel=" + skillLevel +
                '}';
    }
}
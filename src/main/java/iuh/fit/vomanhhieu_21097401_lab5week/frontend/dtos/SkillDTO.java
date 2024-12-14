package iuh.fit.vomanhhieu_21097401_lab5week.frontend.dtos;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.enums.SkillLevel;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Skill;

import java.util.Objects;

public class SkillDTO {
    private Skill skill;
    private String moreInfo;
    private SkillLevel level;

    public SkillDTO() {}

    public SkillDTO(Skill skill, String moreInfo) {
        this.skill = skill;
        this.moreInfo = moreInfo;
    }

    public SkillDTO(Skill skill, String moreInfo, SkillLevel level) {
        this.skill = skill;
        this.moreInfo = moreInfo;
        this.level = level;
    }

    public SkillDTO(Skill skill, SkillLevel level) {
        this.skill = skill;
        this.level = level;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }


    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public SkillLevel getLevel() {
        return level;
    }

    public void setLevel(SkillLevel level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillDTO skillDTO = (SkillDTO) o;
        return Objects.equals(skill, skillDTO.skill) && level == skillDTO.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(skill, level);
    }

    @Override
    public String toString() {
        return "SkillDTO{" +
                "skill=" + skill +
                ", moreInfo='" + moreInfo + '\'' +
                ", level=" + level +
                '}';
    }
}

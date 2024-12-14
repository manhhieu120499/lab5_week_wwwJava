package iuh.fit.vomanhhieu_21097401_lab5week.frontend.dtos;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.enums.SkillLevel;

import java.util.Objects;

public class SkillUpdateDTO {
    private String skillName;
    private String moreInfo;
    private String level;

    public SkillUpdateDTO() {}

    public SkillUpdateDTO(String skillName, String moreInfo, String level) {
        this.skillName = skillName;
        this.moreInfo = moreInfo;
        this.level = level;
    }

    public SkillUpdateDTO(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillUpdateDTO that = (SkillUpdateDTO) o;
        return Objects.equals(skillName, that.skillName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(skillName);
    }

    @Override
    public String toString() {
        return "SkillUpdateDTO{" +
                "skillName='" + skillName + '\'' +
                ", moreInfo='" + moreInfo + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}

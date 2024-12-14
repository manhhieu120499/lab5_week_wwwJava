package iuh.fit.vomanhhieu_21097401_lab5week.backend.models;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.converters.SkillTypeConverter;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.enums.SkillType;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id", nullable = false)
    private Long id;

    @Column(name = "skill_description")
    private String skillDescription;

    @Column(name = "skill_name")
    private String skillName;

    @Convert(converter = SkillTypeConverter.class)
    @Column(name = "type")
    private SkillType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

    public Skill(){}

    public Skill(String skillDescription, String skillName, SkillType type) {
        this.skillDescription = skillDescription;
        this.skillName = skillName;
        this.type = type;
    }

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(skillName, skill.skillName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(skillName);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skillDescription='" + skillDescription + '\'' +
                ", skillName='" + skillName + '\'' +
                ", type=" + type +
                '}';
    }
}
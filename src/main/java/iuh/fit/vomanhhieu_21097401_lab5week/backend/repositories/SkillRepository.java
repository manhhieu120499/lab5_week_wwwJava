package iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    Skill findSkillById(Long id);
    @Query("Select sk from Skill sk join JobSkill jok on sk.id = jok.skill.id where jok.job.id = :id")
    List<Skill> findSkillsByJobId(Long id);
    Skill findSkillBySkillName(String skillName);
}
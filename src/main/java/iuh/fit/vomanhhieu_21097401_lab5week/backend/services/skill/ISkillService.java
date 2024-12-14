package iuh.fit.vomanhhieu_21097401_lab5week.backend.services.skill;


import iuh.fit.vomanhhieu_21097401_lab5week.backend.enums.SkillLevel;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Skill;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.IService;

import java.util.List;
import java.util.Map;

public interface ISkillService extends IService<Skill, Long> {
    public Skill findSkillById(Long id);
    public List<Skill> findSkillBelongToJob(Long id);
    public Skill findSkillBySkillName(String skillName);
    public Map<Skill, SkillLevel> findSkillsBeLongToCandidate(Long candidateId);
}

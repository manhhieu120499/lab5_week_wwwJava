package iuh.fit.vomanhhieu_21097401_lab5week.backend.repositories;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findJobsByCompany_CompName(String companyName);
    @Query("select jo from Job jo join JobSkill jos on jo.id = jos.job.id join Skill sk on jos.skill.id = sk.id where sk.id=:aLong")
    List<Job> findJobComfortableSkill(@Param("aLong") Long id);
    @Modifying
    @Transactional
    @Query("DELETE FROM Job j WHERE j.id = :id")
    void deleteJobById(@Param("id") Long id);
    Job findJobById(Long id);
}
package iuh.fit.vomanhhieu_21097401_lab5week.frontend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.converters.SkillLevelConverter;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.enums.SkillLevel;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.*;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.candidate.ICandidateService;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.company.ICompanyService;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.email.EmailService;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.job.IJobService;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.job_skill.IJobSkillService;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.skill.ISkillService;
import iuh.fit.vomanhhieu_21097401_lab5week.frontend.dtos.JobDTO;
import iuh.fit.vomanhhieu_21097401_lab5week.frontend.dtos.SkillDTO;
import iuh.fit.vomanhhieu_21097401_lab5week.frontend.dtos.SkillUpdateDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private IJobService iJobService;
    @Autowired
    private ICompanyService iCompanyService;
    @Autowired
    private ICandidateService iCandidateService;
    @Autowired
    private IJobSkillService iJobSkillService;

    @Autowired
    private ISkillService iSkillService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/list")
    public String getAllJobs(HttpServletRequest request, Model model, @RequestParam("companyName") String companyName) {
        Iterable<Job> ds = iJobService.findJobByCompanyName(companyName);
        Iterable<Skill> dsSkill = iSkillService.findAll();
        HttpSession session = request.getSession();
        Company c = (Company) session.getAttribute("company");
        System.out.println(c);
        model.addAttribute("jobs", ds);
        model.addAttribute("company", c);
        model.addAttribute("skills", dsSkill);
        return "jobs/jobs";
    }

    @GetMapping("/filter")
    public String filterJobs(Model model, @RequestParam("companyName") String companyName) {
        if(companyName.equals("All")) {
            model.addAttribute("jobs", iJobService.findAll());
        }else {
            model.addAttribute("jobs", iJobService.findJobByCompanyName(companyName));
        }
        model.addAttribute("companies", iCompanyService.findAll());
        model.addAttribute("companyNameSelected", companyName);
        return "jobs/jobs";
    }

    @PostMapping("/create")
    public String addJob(Model model, @RequestParam("companyName") String companyName,
                         @RequestParam("jobName") String jobName,
                         @RequestParam("jobDes") String jobDes,
                         @RequestParam(value = "moreInfo", required = false) List<String> moreInfo,
                         @RequestParam(value="checkSKill", required = false) List<String> checkSKill,
                         @RequestParam(value="skillLevel", required = false) List<String> skillLevel,
                         @RequestHeader(value = "Referer", required = false) String referer) {
        Iterable<Skill> dsSkill = iSkillService.findAll();
        List<Skill> convert_dsSkill = new ArrayList<>();
        dsSkill.forEach(convert_dsSkill::add);
        Company com = iCompanyService.findCompanyByName(companyName);
        Job job = new Job(jobName, jobDes, com);
        iJobService.save(job);

        for(int i = 0 ; i < checkSKill.size() ; i++) {
            JobSkillId jobSkillId = new JobSkillId(job.getId(), Long.parseLong(checkSKill.get(i)));
            System.out.println(skillLevel.get(Integer.parseInt(checkSKill.get(i))));
            int valueOfSkillLevel = Integer.parseInt(skillLevel.get(Integer.parseInt(checkSKill.get(i))));
            System.out.println(valueOfSkillLevel);
            SkillLevel sLevel = null;
            switch (valueOfSkillLevel) {
                case 1: {
                    sLevel = SkillLevel.MASTER;
                    break;
                }
                case 2: {
                    sLevel = SkillLevel.BEGINNER;
                    break;
                }
                case 3: {
                    sLevel = SkillLevel.ADVANCED;
                    break;
                }
                case 4: {
                    sLevel = SkillLevel.PROFESSIONAL;
                    break;
                }
                case 5: {
                    sLevel = SkillLevel.IMTERMEDIATE;
                    break;
                }
            }
            System.out.println("Slevel" + sLevel);
            JobSkill jobSkill = new JobSkill(jobSkillId, job, convert_dsSkill.get(Integer.parseInt(checkSKill.get(i))),
                    moreInfo.get(Integer.parseInt(checkSKill.get(i))), sLevel);
            iJobSkillService.save(jobSkill);
        }
        model.addAttribute("jobs", iJobService.findAll());
        model.addAttribute("companyName", companyName);
        model.addAttribute("skills", iSkillService.findAll());
        if(referer != null) {
            return "redirect:" + referer;
        }
        return "redirect:/jobs";
    }

    @GetMapping("/jobComfortableForSkill")
    public String getJobFollowCandidateSkill(Model model, @RequestParam("canId")String canId) {
        List<Long> skillOfCandidate = iCandidateService.findSkillOfCandidate(Long.parseLong(canId));
        Set<Job> result = new HashSet<>();
        for(Long skillId : skillOfCandidate) {
            List<Job> ds = iJobService.findJobForComfortableSkill(skillId);
            result.addAll(ds);
        }
        model.addAttribute("jobs", result);
        model.addAttribute("companies", iCompanyService.findAll());
        model.addAttribute("candidate", iCandidateService.findById(Long.parseLong(canId)).get());
        model.addAttribute("selectedCompanyName", "All");
        return "candidates/suggest-job";
    }

    @GetMapping("/delete")
    public String handleDeleteJob(Model model, @RequestParam("id") String id,
                                  @RequestParam("companyName") String companyName,
                                  @RequestHeader(value = "referer") String referer) {
        if(iJobService.delete(Long.parseLong(id))) {
            Iterable<Job> ds = iJobService.findJobByCompanyName(companyName);
            Iterable<Skill> dsSkill = iSkillService.findAll();
            model.addAttribute("jobs", ds);
            model.addAttribute("companyName", companyName);
            model.addAttribute("skills", dsSkill);
            if(referer != null) {
                return "redirect:" + referer;
            }
            return "jobs/jobs";
        }
        model.addAttribute("errorMessage", "Delete job not successful");
        return "error/message-error";
    }

    @GetMapping("/viewDetail")
    public String getDetailJob(Model model,@RequestParam("id") String id){
        Optional<Job> jo = iJobService.findById(Long.parseLong(id));
        List<Skill> dsSkillOfJob = iSkillService.findSkillBelongToJob(Long.parseLong(id));
        List<SkillDTO> dsSkillDTO = new ArrayList<>();
        for (Skill skill : dsSkillOfJob) {
            JobSkill jobSkill = iJobSkillService.findJobSkillBySkillIdAndJobId(skill.getId(), Long.parseLong(id));
            dsSkillDTO.add(new SkillDTO(skill, jobSkill.getMoreInfos()));
        }
        model.addAttribute("job",jo.orElse(null));
        model.addAttribute("skills", dsSkillOfJob.size() > 0 ? dsSkillDTO : null);
        return "jobs/job-detail";
    }

    @GetMapping("/candidate/viewDetail")
    public String getDetailJobForCandidate(HttpServletRequest request, Model model,@RequestParam("id") String id){
        HttpSession session = request.getSession();
        // lấy thông tin của candidate
        Candidate ca = (Candidate) session.getAttribute("candidate");
        // tìm danh sách skill mà ứng cử viên có
        Map<Skill, SkillLevel> skillSkillLevelMap = iSkillService.findSkillsBeLongToCandidate(ca.getId());
        // danh sách skill mà ứng cử viên có
        List<SkillDTO> dsSkillDTOCandidateHave = new ArrayList<>();
        skillSkillLevelMap.forEach((entry, value) -> {
            dsSkillDTOCandidateHave.add(new SkillDTO(entry, value));
        });

        System.out.println("3" + dsSkillDTOCandidateHave);

        Optional<Job> jo = iJobService.findById(Long.parseLong(id));
        // danh sách skill của job yêu cầu
        List<Skill> dsSkillOfJob = iSkillService.findSkillBelongToJob(Long.parseLong(id));
        List<SkillDTO> dsSkillDTO = new ArrayList<>();
        List<SkillDTO> dsSkillDTOToCompare = new ArrayList<>();
        for (Skill skill : dsSkillOfJob) {
            JobSkill jobSkill = iJobSkillService.findJobSkillBySkillIdAndJobId(skill.getId(), Long.parseLong(id));
            dsSkillDTO.add(new SkillDTO(skill, jobSkill.getMoreInfos()));
            dsSkillDTOToCompare.add(new SkillDTO(skill, jobSkill.getSkillLevel()));
        }

        System.out.println("1" + dsSkillDTOToCompare);

        // so sánh
        List<SkillDTO> dsSkillDTOToSuggest = new ArrayList<>();
        dsSkillDTOToCompare.forEach(skillJob -> {
            if(!dsSkillDTOCandidateHave.contains(skillJob)) {
                dsSkillDTOToSuggest.add(skillJob);
            }
        });

        System.out.println("2" + dsSkillDTOToSuggest);

        model.addAttribute("job",jo.orElse(null));
        model.addAttribute("skills", dsSkillOfJob.size() > 0 ? dsSkillDTO : null);
        model.addAttribute("skillsSuggest", dsSkillDTOToSuggest.size() > 0 ? dsSkillDTOToSuggest : null);
        return "jobs/job-detail";
    }

    @GetMapping("/filterJobForCandidate/{canId}/{companyName}")
    public String filterJobForCandidate(Model model, @PathVariable("canId") String canId, @PathVariable("companyName") String companyName) {
        List<Long> skillOfCandidate = iCandidateService.findSkillOfCandidate(Long.parseLong(canId));
        Set<Job> result = new HashSet<>();
        for(Long skillId : skillOfCandidate) {
            List<Job> ds = iJobService.findJobForComfortableSkill(skillId);
            result.addAll(ds);
        }
        if(companyName.equalsIgnoreCase("All")) {
            model.addAttribute("jobs", result);
        }else {
            List<Job> jobAfterFilter = result.stream().filter(item -> item.getCompany().getCompName().equalsIgnoreCase(companyName)).collect(Collectors.toCollection(ArrayList::new));
            model.addAttribute("jobs", jobAfterFilter);
        }
        model.addAttribute("selectedCompanyName", companyName);
        model.addAttribute("companies", iCompanyService.findAll());
        model.addAttribute("candidate", iCandidateService.findById(Long.parseLong(canId)).get());
        return "candidates/suggest-job";
    }

    @GetMapping("/edit/{jobId}")
    public String editJob(Model model, @PathVariable("jobId") String jobId) {
        Optional<Job> jo = iJobService.findById(Long.parseLong(jobId));
        Iterable<Skill> dsSkill = iSkillService.findAll();
        List<Skill> convertSkillForModal = new ArrayList<>();
        dsSkill.forEach(convertSkillForModal::add);
        List<Skill> skillsOfJob = iSkillService.findSkillBelongToJob(Long.parseLong(jobId));
        List<SkillDTO> convertSkillDTOForTable = new ArrayList<>();
        for(Skill skill : skillsOfJob) {
            JobSkill jobSkill = iJobSkillService.findJobSkillBySkillIdAndJobId(skill.getId(), Long.parseLong(jobId));
            convertSkillDTOForTable.add(new SkillDTO(skill, jobSkill.getMoreInfos(), jobSkill.getSkillLevel()));
        }
        model.addAttribute("job", jo.get());
        model.addAttribute("skillsForModal", convertSkillForModal);
        model.addAttribute("skillsForTable", convertSkillDTOForTable);
        return "jobs/edit-job";
    }

    @GetMapping("/update")
    public String updateJob(HttpServletRequest request,@RequestParam("data") String data, Boolean checkEdit, Model model,
                            @RequestHeader(value = "referer") String referer) {
        System.out.println(data);
        System.out.println(checkEdit);
        HttpSession session = request.getSession();
        ObjectMapper mapper = new ObjectMapper();
            try{
                JobDTO jobDTO = mapper.readValue(data, JobDTO.class);
                Job jo = iJobService.findById(Long.parseLong(jobDTO.getJobId())).get();
                if(!checkEdit) {
                    Iterable<Job> ds = iJobService.findJobByCompanyName(jo.getCompany().getCompName());
                    Iterable<Skill> dsSkill = iSkillService.findAll();
                    model.addAttribute("jobs", ds);
                    model.addAttribute("company", (Company) session.getAttribute("company"));
                    model.addAttribute("skills", dsSkill);
                    if(referer != null) {
                        return "redirect:list?companyName=" + jo.getCompany().getCompName();
                    }
                }else {
                    jo.setJobDesc(jobDTO.getJobDes());
                    jo.setJobName(jobDTO.getJobName());
                    // lấy danh sách các skill của job
                    // danh sách cũ
                    List<Skill> skillsOfJob = iSkillService.findSkillBelongToJob(jo.getId());
                    if(jobDTO.getSkills().size() > skillsOfJob.size()) {
                        jobDTO.getSkills().forEach(skill -> {
                            Skill temp = new Skill(skill.getSkillName());
                            if(!skillsOfJob.contains(temp)) {
                                Skill newSkill = iSkillService.findSkillBySkillName(skill.getSkillName());
                                JobSkillId jobSkillId = new JobSkillId(jo.getId(), newSkill.getId());
                                SkillLevel skillLevel = skill.getLevel().equalsIgnoreCase("beginner") ? SkillLevel.BEGINNER :
                                        skill.getLevel().equalsIgnoreCase("master") ? SkillLevel.MASTER :
                                                skill.getLevel().equalsIgnoreCase("advanced") ? SkillLevel.ADVANCED :
                                                        skill.getLevel().equalsIgnoreCase("professional") ? SkillLevel.PROFESSIONAL : SkillLevel.IMTERMEDIATE;
                                JobSkill jobSkill = new JobSkill(jobSkillId, jo, newSkill, skill.getMoreInfo(), skillLevel);
                                try{
                                    iJobSkillService.save(jobSkill);
                                    System.out.println("Save success");
                                }catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }else if(jobDTO.getSkills().size() < skillsOfJob.size()) {
                        skillsOfJob.forEach(skill -> {
                            SkillUpdateDTO temp = new SkillUpdateDTO(skill.getSkillName());
                            if(!jobDTO.getSkills().contains(temp)) {
                                iJobSkillService.deleteJobsSkillByJob_IdAndSkill_Id(jo.getId(), skill.getId());
                                skillsOfJob.remove(skill);
                            }
                        });
                    }else {
                        skillsOfJob.forEach(skill -> {
                            SkillUpdateDTO temp = new SkillUpdateDTO(skill.getSkillName());
                            if(!jobDTO.getSkills().contains(temp)) {
                                iJobSkillService.deleteJobsSkillByJob_IdAndSkill_Id(jo.getId(), skill.getId());
                            }
                        });
                        jobDTO.getSkills().forEach(skill -> {
                            Skill temp = new Skill(skill.getSkillName());
                            if(!skillsOfJob.contains(temp)) {
                                Skill newSkill = iSkillService.findSkillBySkillName(skill.getSkillName());
                                JobSkillId jobSkillId = new JobSkillId(jo.getId(), newSkill.getId());
                                SkillLevel skillLevel = skill.getLevel().equalsIgnoreCase("beginner") ? SkillLevel.BEGINNER :
                                        skill.getLevel().equalsIgnoreCase("master") ? SkillLevel.MASTER :
                                                skill.getLevel().equalsIgnoreCase("advanced") ? SkillLevel.ADVANCED :
                                                        skill.getLevel().equalsIgnoreCase("professional") ? SkillLevel.PROFESSIONAL : SkillLevel.IMTERMEDIATE;
                                JobSkill jobSkill = new JobSkill(jobSkillId, jo, newSkill, skill.getMoreInfo(), skillLevel);
                                try{
                                    iJobSkillService.save(jobSkill);
                                    System.out.println("Save success");
                                }catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    iJobService.update(jo);
                    Iterable<Job> ds = iJobService.findJobByCompanyName(jo.getCompany().getCompName());
                    Iterable<Skill> dsSkill = iSkillService.findAll();
                    model.addAttribute("jobs", ds);
                    model.addAttribute("company", (Company) session.getAttribute("company"));
                    model.addAttribute("skills", dsSkill);
                    if(referer != null) {
                        return "redirect:list?companyName=" + jo.getCompany().getCompName();
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

        return "jobs/jobs";
    }

    @GetMapping("/news")
    public String newsOfJob(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute("company");
        Iterable<Job> jobList = iJobService.findJobByCompanyName(company.getCompName());
        model.addAttribute("jobs", jobList);
        model.addAttribute("company", company);
        return "jobs/news-job";
    }

    @GetMapping("/viewMail")
    public String getViewMail(HttpServletRequest request, Model model, @RequestParam("email") String email) {
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute("company");
        model.addAttribute("emailCompany", company.getEmail());
        model.addAttribute("emailCandidate", email);
        return "jobs/mail";
    }

    @PostMapping("mail/send")
    public String sendMailInterview(@RequestParam("emailCompany") String emailCompany, @RequestParam("emailCandidate") String emailCandidate,
                                    @RequestParam("subject") String subject, @RequestParam("content") String content, Model model) {

        try{
            emailService.sendEmail(emailCandidate, subject, content);
            model.addAttribute("message", "Send Mail Success!");
            model.addAttribute("emailCompany", "");
            model.addAttribute("emailCandidate", "");
        }catch (Exception e) {
            model.addAttribute("message", "Send Mail Failed!");
        }
        return "jobs/mail";
    }
}

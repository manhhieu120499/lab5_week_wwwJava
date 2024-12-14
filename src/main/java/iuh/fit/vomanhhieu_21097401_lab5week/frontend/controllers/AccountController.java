package iuh.fit.vomanhhieu_21097401_lab5week.frontend.controllers;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Account;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Candidate;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Company;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Job;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.account.IAccountService;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.candidate.ICandidateService;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.company.ICompanyService;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.job.IJobService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private ICandidateService iCandidateService;

    @Autowired
    private ICompanyService iCompanyService;

    @Autowired
    private IJobService iJobService;


    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @PostMapping("/login")
    public String loginPage(HttpServletRequest request, Model model, @RequestParam("username") String username,
                            @RequestParam("password") String password) {
        HttpSession session = request.getSession();
        if(username == null || password == null) {
            model.addAttribute("error", "Email or password is empty");
            return "index";
        }else {
            Account acc = iAccountService.findAccountByUsernameAndPassword(username, password);
            if(acc != null) {
                if(acc.getRole().getValue().equalsIgnoreCase("company")) {
                    Company c = iCompanyService.findCompanyByAccountId(acc.getId());
                    model.addAttribute("company", c);
                    session.setAttribute("company", c);
                    return "home/company-home";
                }else {
                    Candidate ca = iCandidateService.findCandidateByAccountId(acc.getId());
                    model.addAttribute("candidate", ca);
                    List<Long> skillOfCandidate = iCandidateService.findSkillOfCandidate(ca.getId());
                    List<Job> result = new ArrayList<>();
                    for(Long skillId : skillOfCandidate) {
                        List<Job> ds = iJobService.findJobForComfortableSkill(skillId);
                        result.addAll(ds);
                    }
                    model.addAttribute("jobs", result);
                    model.addAttribute("companies", iCompanyService.findAll());
                    // xet du lieu cho session
                    session.setAttribute("candidate", ca);
                    session.setAttribute("jobs", result);
                    session.setAttribute("companies", iCompanyService.findAll());
                    return "home/candidate-home";
                }
            }else {
                model.addAttribute("error", "Invalid username or password");
                return "index";
            }

        }
    }

    @GetMapping("/logout")
    public String logoutAccount(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "index";
    }
}

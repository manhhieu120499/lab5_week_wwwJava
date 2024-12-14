package iuh.fit.vomanhhieu_21097401_lab5week.frontend.controllers;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Company;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.candidate.ICandidateService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class TransferPageController {
    @Autowired
    private ICandidateService iCandidateService;
    @GetMapping("home-candidate")
    public String homeCandidate(Model model, @RequestParam("canId") String canId) {
        model.addAttribute("candidate", iCandidateService.findById(Long.parseLong(canId)).get());
        return "home/candidate-home";
    }

    @GetMapping("home-company")
    public String homeCompany(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        model.addAttribute("company", (Company) session.getAttribute("company"));
        return "home/company-home";
    }
}

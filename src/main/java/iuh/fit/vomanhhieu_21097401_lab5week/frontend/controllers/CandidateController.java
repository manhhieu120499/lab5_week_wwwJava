package iuh.fit.vomanhhieu_21097401_lab5week.frontend.controllers;

import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Candidate;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.models.Company;
import iuh.fit.vomanhhieu_21097401_lab5week.backend.services.candidate.ICandidateService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private ICandidateService iCandidateService;

    @GetMapping("/list")
    public String showAllCandidate(Model model) {
        model.addAttribute("candidates", iCandidateService.findAll());
        return "candidates/candidate";
    }

    @GetMapping("")
    public String showCandidateListPaging(HttpServletRequest request, Model model,
                                          @RequestParam("page")Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size) {
        HttpSession session = request.getSession();
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage= iCandidateService.findPaging(
                currentPage - 1,pageSize,"id","asc");
        model.addAttribute("candidatePage", candidatePage);
        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("company", (Company) session.getAttribute("company"));
        return "candidates/candidate-paging";
    }

    @GetMapping("/add-candidate")
    public String addCandidate() {
        return "candidates/add-candidate";
    }
}

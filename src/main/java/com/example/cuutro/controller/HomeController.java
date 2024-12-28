package com.example.cuutro.controller;

import com.example.cuutro.dto.request.ThongTinRequest;
import com.example.cuutro.service.CuuTroService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class HomeController {
    CuuTroService cuuTroService;

    @GetMapping("/add")
    public String home(Model model) {
        model.addAttribute("cuuTroDto", new ThongTinRequest());
        model.addAttribute("truongs", cuuTroService.getTruongs());
        model.addAttribute("dotCuuTros", cuuTroService.getDotCuuTros());
        return "pages/index";
    }

    @PostMapping("/addInfoCuuTro")
    public String saveInfo(Model model, @Valid @ModelAttribute("cuuTroDto") ThongTinRequest request, BindingResult result) {
        if(result.hasErrors()) {
            model.addAttribute("truongs", cuuTroService.getTruongs());
            model.addAttribute("dotCuuTros", cuuTroService.getDotCuuTros());
            return "pages/index";
        }
        cuuTroService.saveCuuTro(request);
        return "pages/index";
    }

    @RequestMapping("/search")
    public String searchInfo2(Model model, @Param("keyword") String keyword) {
        model.addAttribute("keyword", keyword);
        model.addAttribute("listCuuTro", cuuTroService.findInfoDetail(keyword));
        return "pages/searchInfo";
    }

    @GetMapping("/delete/{maSV}")
    public String deleteInfo(Model model, @PathVariable Long maSV) {
        cuuTroService.deleteInfo(maSV);
        return "redirect:/search";
    }
}

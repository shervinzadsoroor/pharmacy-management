package com.shervin.models.crud.drugrepository;

import com.shervin.models.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    public DrugService drugService;

    @GetMapping("/save")
    public String sendForm(Model model) {
        model.addAttribute("drug", new Drug());
        return "drug";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Drug drug) {
        drugService.saveDrug(drug);
        return "drug saved";
    }

}

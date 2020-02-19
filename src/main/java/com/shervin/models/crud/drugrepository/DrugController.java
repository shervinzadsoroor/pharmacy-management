package com.shervin.models.crud.drugrepository;

import com.shervin.models.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    public DrugService drugService;


    @GetMapping("/save")
    public String sendForm(Model model) {
        model.addAttribute("drug", new Drug());
        return "addDrug";
    }


    @PostMapping("/save")
    public String saveBook(@ModelAttribute Drug drug) {
        drugService.saveDrug(drug);
        return "drugSaved";
    }

    @GetMapping("/list")
    public String showAll(Model model) {
        model.addAttribute("drugs", drugService.showAllDrugs());
        model.addAttribute("drug", new Drug());
        return "allDrugs";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long drugId, Model model) {

        model.addAttribute("editDrug", drugService.findDrugById(drugId));
        return "editDrug";
    }

    @PostMapping("/edit")
    public String editDug(@ModelAttribute Drug editedDrug) {
        drugService.saveDrug(editedDrug);
        return "index";
    }


}

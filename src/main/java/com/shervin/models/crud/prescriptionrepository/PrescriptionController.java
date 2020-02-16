package com.shervin.models.crud.prescriptionrepository;

import com.shervin.models.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/save")
    public String sendForm(Model model){
        model.addAttribute("prescription",new Prescription());
        return "addPrescription";
    }
}

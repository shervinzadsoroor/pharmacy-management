package com.shervin.models.crud.prescriptionrepository;

import com.shervin.models.Prescription;
import com.shervin.models.crud.prescriptionrepository.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/save")
    public String sendForm(Model model) {
        model.addAttribute("prescription", new Prescription());
        return "addPrescription";
    }

    @PostMapping("/save")
    public String savePrescription(Prescription prescription) {
        prescriptionService.savePrescription(prescription);
        return "prescriptionSaved";
    }

    @GetMapping("/list")
    public String showAll(Model model) {
        System.out.println("hello");
        model.addAttribute("prescriptions", prescriptionService.showAllPrescriptions());
        return "allPrescriptions";
    }
}

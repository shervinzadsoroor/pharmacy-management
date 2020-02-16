package com.shervin.models.crud.patientrepository;

import com.shervin.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    public PatientService patientService;

    @GetMapping("/save")
    public String sendPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "addPatient";
    }

    @PostMapping("/save")
    public String savePatient(@ModelAttribute Patient patient) {
        patientService.save(patient);
        return "patientSaved";
    }
    @GetMapping("/list")
    public String showAllPatients(Model model){
        model.addAttribute("patients",patientService.showAllPatients());
        return "allPatients";
    }
}

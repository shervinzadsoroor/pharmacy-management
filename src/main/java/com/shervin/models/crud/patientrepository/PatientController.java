package com.shervin.models.crud.patientrepository;

import com.shervin.models.Patient;
import com.shervin.models.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String savePatient(@ModelAttribute Patient patient, Model model) {
        patientService.save(patient);
        Prescription prescription = new Prescription();
        prescription.setPatient(patient);
        model.addAttribute("prescription",prescription);
//        model.addAttribute("patient",patient);
        return "addPrescription";
    }

    @GetMapping("/list")
    public String showAllPatients(Model model) {
        model.addAttribute("patients", patientService.showAllPatients());
        return "allPatients";
    }

    @GetMapping("/edit/{id}")
    public String sendEditForm(@PathVariable("id") Long editId, Model model) {
        model.addAttribute("editPatient", patientService.findById(editId));
        return "editPatient";
    }

    @PostMapping("/edit")
    public String editPatient(@ModelAttribute Patient patient) {
        patientService.save(patient);
        return "index";
    }

    @GetMapping("/details/{id}")
    public String sendPatientDetails(@PathVariable("id")Long detailId, Model model){
        model.addAttribute("detailedPatient", patientService.findById(detailId));
        return "patientDetails";
    }

    @GetMapping("/deleteConfirm/{id}")
    public String confirmDelete(@PathVariable("id") Long deleteId, Model model) {
        model.addAttribute("deletePatient", patientService.findById(deleteId));
        return "deletePatient";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id")Long deleteId){
        patientService.deletePatient(deleteId);
        return "index";
    }

    //shows the list of patients to choose one of them to add prescription
    @GetMapping("/add")
    public String addPrescription(Model model) {
        model.addAttribute("patients", patientService.showAllPatients());
        return "addPrescriptionToExistingPatient";
    }
}

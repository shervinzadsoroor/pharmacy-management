package com.shervin.models.crud.prescriptionrepository;

import com.shervin.models.Patient;
import com.shervin.models.Prescription;
import com.shervin.models.crud.patientrepository.PatientService;
import com.shervin.models.crud.prescriptionrepository.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private PatientService patientService;

    @GetMapping("/save")
    public String sendForm(Model model) {
        model.addAttribute("prescription", new Prescription());
        return "addPrescription";
    }

    @PostMapping("/save")
    public String savePrescription(Prescription prescription) {
        prescriptionService.savePrescription(prescription);
        return "index";
    }

    @GetMapping("/saveToExistingPatientForm/{id}")
    public String saveToExistingPatient(@PathVariable("id") Long patientId,Model model) {
        Patient patient = patientService.findById(patientId);
        Prescription prescription = new Prescription();
        prescription.setPatient(patient);
        model.addAttribute("prescription",prescription);
        return "addPrescription";
    }

    @GetMapping("/list")
    public String showAll(Model model) {
        model.addAttribute("prescriptions", prescriptionService.showAllPrescriptions());
        return "allPrescriptions";
    }

    @GetMapping("/edit/{id}")
    public String editPrescriptionForm(@PathVariable("id")Long presId, Model model){
        model.addAttribute("prescription",prescriptionService.findById(presId));
        return "editPrescription";
    }

    @PostMapping("/edit")
    public String saveEditedPrescription(Prescription prescription){
        prescriptionService.savePrescription(prescription);
        return "index";
    }
}

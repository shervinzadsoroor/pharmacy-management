package com.shervin.models.crud.prescriptionrepository;

import com.shervin.models.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public void savePrescription(Prescription prescription) {
        prescriptionRepository.save(prescription);
    }

    public List<Prescription> showAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Prescription findById(Long id){
       return prescriptionRepository.findById(id).get();
    }
}

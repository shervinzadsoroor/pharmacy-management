package com.shervin.models.crud.patientrepository;

import com.shervin.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    public PatientRepository patientRepository;

    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    public List<Patient> showAllPatients(){
        return patientRepository.findAll();
    }

    public Patient findById(Long id){
      return  patientRepository.findById(id).get();
    }

    public void deletePatient(Long deleteId) {
        patientRepository.deleteById(deleteId);
    }
}

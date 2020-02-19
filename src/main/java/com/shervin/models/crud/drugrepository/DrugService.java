package com.shervin.models.crud.drugrepository;

import com.shervin.models.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrugService {
    @Autowired
    public DrugRepository drugRepository;

    public void saveDrug(Drug drug) {
        drugRepository.save(drug);
    }

    public List<Drug> showAllDrugs() {
        return drugRepository.findAll();
    }

    public Optional<Drug> findDrugById(Long id) {
        return drugRepository.findById(id);
    }
}

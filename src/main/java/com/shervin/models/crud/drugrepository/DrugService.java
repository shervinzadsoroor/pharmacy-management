package com.shervin.models.crud.drugrepository;

import com.shervin.models.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugService {
    @Autowired
    public DrugRepository drugRepository;

    public void saveDrug(Drug drug) {
        drugRepository.save(drug);
    }
}

package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Vaccination;
import vn.codegym.pig_farm.repository.IVaccinationRepository;
import vn.codegym.pig_farm.service.IVaccinationService;

import java.util.List;

@Service
public class VaccinationServiceImpl implements IVaccinationService {
    @Autowired
    private IVaccinationRepository iVaccinationRepository;

    @Override
    public List<Vaccination> findAll() {
        return iVaccinationRepository.getAll();
    }

    @Override
    public void saveVaccination(Vaccination vaccination) {
        iVaccinationRepository.createVaccination(vaccination.getAmount(), vaccination.getDate(),
                vaccination.getNote(), vaccination.getVaccinatedPerson(), vaccination.getVaccineType(), vaccination.getPigsty());
    }
}

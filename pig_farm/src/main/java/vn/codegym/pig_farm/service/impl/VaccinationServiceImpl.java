package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Vaccination;
import vn.codegym.pig_farm.repository.VaccinationRepository;
import vn.codegym.pig_farm.service.IVaccinationService;


@Service
public class VaccinationServiceImpl implements IVaccinationService {

    @Autowired
    private VaccinationRepository vaccinationRepository;

    /**
     * @param pageable
     * @param name
     * @return List Vaccination, status 200
     * @function (Display all Vaccination and search)
     * @creator TamLT
     * @date-create 08/09/2022
     */

    @Override
    public Page<Vaccination> getAll(Pageable pageable, String name) {
        return vaccinationRepository.getAllVaccination(pageable, "%" + name + "%");
    }


    /**
     * @param ids
     * @return Delete Vaccination, status 200
     * @function (Delete Vaccination)
     * @creator TamLT
     * @date-create 08/09/2022
     */

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids){
            vaccinationRepository.delete(id);
        }
    }
}

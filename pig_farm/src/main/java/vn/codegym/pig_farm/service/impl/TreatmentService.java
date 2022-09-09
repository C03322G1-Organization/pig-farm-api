package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.dto.ITreatmentDto;
import vn.codegym.pig_farm.entity.Treatment;
import vn.codegym.pig_farm.repository.TreatmentRepository;
import vn.codegym.pig_farm.service.ITreatmentService;

import java.util.List;

@Service
public class TreatmentService implements ITreatmentService {
    @Autowired
    private TreatmentRepository treatmentRepository;

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * Override method findAllTreatment
     * @return
     */
    @Override
    public Page<ITreatmentDto> getAllTreatment(Pageable pageable, String keySearch) {
        System.out.printf("--------------- "+keySearch+" ---------------");
        return treatmentRepository.getAllTreatment( pageable,"%" + keySearch + "%");
    }

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * Override method deleteByIdTreatment
     * @return
     */
    @Override
    public void deleteByIdTreatment(int id) {
        treatmentRepository.deleteByIdTreatment(id);
    }


}

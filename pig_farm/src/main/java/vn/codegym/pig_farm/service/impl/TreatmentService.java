package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.dto.projections.TreatmentDto;
import vn.codegym.pig_farm.entity.Treatment;
import vn.codegym.pig_farm.repository.TreatmentRepository;
import vn.codegym.pig_farm.service.ITreatmentService;

@Service
public class TreatmentService implements ITreatmentService {
    @Autowired
    TreatmentRepository treatmentRepository;

    /**
     * create by TuongTK
     * date: 08/09/2022
     * override method save(Treatment treatment)
     *
     * @param treatment
     */
    @Override
    public void save(Treatment treatment) {
        treatmentRepository.save(treatment.getId(), treatment.getDate(), treatment.getDoctor(), treatment.getDiseases(), treatment.getMedicine(), treatment.getAmount(), treatment.getPig());
    }

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * Override method findAllTreatment
     *
     * @return
     */
    @Override
    public Page<TreatmentDto> getAllTreatment(Pageable pageable, String keySearch) {
        return treatmentRepository.getAllTreatment(pageable, "%" + keySearch + "%");
    }

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * Override method deleteByIdTreatment
     *
     * @return
     */
    @Override
    public void deleteByIdTreatment(int id) {
        treatmentRepository.deleteByIdTreatment(id);
    }


    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * Override method findById
     *
     * @return
     */
    @Override
    public TreatmentDto findById(int id) {
        return treatmentRepository.findByIdTreatment(id);
    }
}

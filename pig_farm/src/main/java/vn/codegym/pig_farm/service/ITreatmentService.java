package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.dto.ITreatmentDto;
import vn.codegym.pig_farm.entity.Treatment;

import java.util.List;

public interface ITreatmentService {

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * create method getAllTreatment
     * @return
     */
    List<ITreatmentDto> getAllTreatment();

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * create method deleteByIdTreatment
     * @return
     * @param id
     */
    void deleteByIdTreatment(int id);
}

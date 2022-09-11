package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.dto.ITreatmentDto;
import vn.codegym.pig_farm.entity.Treatment;

import java.util.Optional;


public interface ITreatmentService {

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * create method getAllTreatment
     * @return
     */
    Page<ITreatmentDto> getAllTreatment(Pageable pageable, String keySearch);

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * create method deleteByIdTreatment
     * @return
     * @param id
     */
    void deleteByIdTreatment(int id);

    Treatment findById(int id);
}

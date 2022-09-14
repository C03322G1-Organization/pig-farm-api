package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.dto.projections.TreatmentDto;
import vn.codegym.pig_farm.entity.Treatment;


public interface ITreatmentService {
    /**
     * create by TuongTK
     * date: 08/09/2022
     * create method save(Treatment treatment)
     *
     * @param treatment
     */
    void save(Treatment treatment);

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * create method getAllTreatment
     *
     * @return
     */
    Page<TreatmentDto> getAllTreatment(Pageable pageable, String keySearch);

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * create method deleteByIdTreatment
     *
     * @param id
     * @return
     */
    void deleteByIdTreatment(int id);

    TreatmentDto findById(int parseInt);

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * create method findById
     * @return
     * @param id
     */
}

package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.entity.Pig;

import java.util.List;
import java.util.Optional;

public interface IPigService {

    /**
     * @param pageable
     * @param code
     * @param dateIn
     * @param status
     * @return Page<Pig>, status 200
     * @function (display all Pig and search)
     * @creator LamNT
     * @date-create 08/09/2022
     */

    Page<Pig> findAllPig(Pageable pageable, String code, String dateIn, String status);

    /**
     * @param id
     * @return void, status 200
     * @function (delete Pig by id)
     * @creator LamNT
     * @date-create 08/09/2022
     */
    void deletePigById(Pig id);

    /**
     * @param id
     * @return Optional<Pig>, status 200
     * @function (delete Pig by id)
     * @creator LamNT
     * @date-create 08/09/2022
     */
    Optional<Pig> findById(int id);

    List<Pig> findAll();

    /**
     * Created by: DatVT
     * Date created: 08/09/2022
     * Function: findById
     */
    Pig findById(Integer id);

    /**
     * Created by: DatVT
     * Date created: 08/09/2022
     * Function: createPig
     */
    void createPig(Pig pig);

    /**
     * Created by: DatVT
     * Date created: 08/09/2022
     * Function: updatePig
     */
    void updatePig(Integer id,Pig pig);
}

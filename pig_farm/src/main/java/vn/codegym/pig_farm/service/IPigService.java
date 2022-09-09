package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.entity.Pig;

import java.util.List;

public interface IPigService {
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

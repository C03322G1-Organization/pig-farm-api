package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.entity.Pigsty;

public interface IPigstyService {
    /**
     * Create by PhucND
     * Date Create: 08/09/2022
     * This findAll
     *
     * Param search,pageable
     */
    Page<Pigsty> findAll(Pageable pageable,String search);
}

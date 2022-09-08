package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.entity.Pigsty;

public interface IPigstyService {
    Page<Pigsty> findAll(Pageable pageable,String search);
}

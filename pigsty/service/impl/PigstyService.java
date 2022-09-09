package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Pigsty;
import vn.codegym.pig_farm.repository.IPigstyRepository;
import vn.codegym.pig_farm.service.IPigstyService;
@Service
public class PigstyService implements IPigstyService {
    @Autowired
    private IPigstyRepository iPigstyRepository;
    /**
     * Create by PhucND
     * Date Create: 08/09/2022
     * This findAll
     *
     * Param search,pageable
     */
    @Override
    public Page<Pigsty> findAll(Pageable pageable, String search) {
        return iPigstyRepository.findAll(pageable,"%"+search+"%");
    }
}

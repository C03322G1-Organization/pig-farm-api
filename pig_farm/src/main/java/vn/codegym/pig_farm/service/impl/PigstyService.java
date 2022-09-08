package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Pigsty;
import vn.codegym.pig_farm.repository.IPigstyRepository;
import vn.codegym.pig_farm.service.IPigstyService;

import java.util.List;

@Service
public class PigstyService implements IPigstyService {
    @Autowired
    private IPigstyRepository iPigstyRepository;

    /**
     * Created by: HieuCD
     * Date created: 08/09/2022
     * function: create a Pigsty
     * @param pigsty
     */
    @Override
    public void createPigsty(Pigsty pigsty) {
        this.iPigstyRepository.createPigsty(pigsty);
    }

    /**
     * Created by: HieuCD
     * Date created: 08/09/2022
     * function: edit a Pigsty
     * @param pigsty
     */
    @Override
    public void editPigsty(Pigsty pigsty) {

    }

    /**
     * Created by: HieuCD
     * Date created: 08/09/2022
     * function: get a Pigsty by id
     * @param id
     * @return return a pigsty
     */
    @Override
    public Pigsty getPigstyById(Integer id) {
        return null;
    }


}

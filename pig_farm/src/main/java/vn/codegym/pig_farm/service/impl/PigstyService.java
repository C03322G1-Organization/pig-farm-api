package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Pigsty;
import vn.codegym.pig_farm.repository.PigstyRepository;
import vn.codegym.pig_farm.service.IPigstyService;

import java.util.List;

@Service
public class PigstyService implements IPigstyService {
    @Autowired
    private PigstyRepository pigstyRepository;
    @Override
    public List<Pigsty> listPigsty() {
        return pigstyRepository.findALLPigsty();
    }
}

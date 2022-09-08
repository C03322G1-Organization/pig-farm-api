package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Pig;
import vn.codegym.pig_farm.repository.IPigRepository;
import vn.codegym.pig_farm.service.IPigService;

import java.util.List;

@Service
public class PigService implements IPigService {
    @Autowired
    private IPigRepository pigRepository;

    public List<Pig> findAll() {
        return pigRepository.findAll();
    }
    /**
     * Created by: DatVT
     * Date created: 08/09/2022
     * Function: findById
     */
    @Override
    public Pig findById(Integer id) {
        return pigRepository.findByIdPig(id);
    }
    /**
     * Created by: DatVT
     * Date created: 08/09/2022
     * Function: createPig
     */
    @Override
    public void createPig(Pig pig) {
        pigRepository.createPig(
                pig.getCode(),
                pig.getDateIn(),
                pig.getDateOut(),
                pig.getStatus(),
                pig.getWeight(),
                pig.getPigsty().getId());

    }
    /**
     * Created by: DatVT
     * Date created: 08/09/2022
     * Function: updatePig
     */
    @Override
    public void updatePig( Pig pig) {
        pigRepository.updatePig(
                pig.getCode(),
               pig.getDateIn(),pig.getDateOut(),pig.getStatus(),pig.getWeight(),pig.getPigsty(),pig.getId());
    }
}

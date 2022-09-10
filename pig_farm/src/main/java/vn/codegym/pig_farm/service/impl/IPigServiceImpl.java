package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Pig;
import vn.codegym.pig_farm.repository.PigRepository;
import vn.codegym.pig_farm.service.IPigService;

import java.util.Optional;

@Service
public class IPigServiceImpl implements IPigService {

    @Autowired
    private PigRepository pigRepository;

    /**
     * @param pageable
     * @param code
     * @param dateIn
     * @param status
     * @return pig, status 200
     * @function (display all Pig and search)
     * @creator LamNT
     * @date-create 08/09/2022
     */

    @Override
    public Page<Pig> findAllPig(Pageable pageable, String code, String dateIn, String status) {
        return pigRepository.findAllPig(pageable, "%" + code + "%","%" + dateIn + "%", "%" + status + "%");
    }

    /**
     * @param id
     * @return pig, status 200
     * @function (delete Pig by id)
     * @creator LamNT
     * @date-create 08/09/2022
     */

    @Override
    public void deletePigById(Pig id) {
        pigRepository.delete(id);
    }

    /**
     * @param id
     * @return pig, status 200
     * @function (find Pig by id)
     * @creator LamNT
     * @date-create 08/09/2022
     */

    @Override
    public Optional<Pig> findById(int id) {
        return pigRepository.findByIdPig(id);
    }

}

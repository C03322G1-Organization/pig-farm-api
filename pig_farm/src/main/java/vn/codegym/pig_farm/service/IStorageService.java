package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.dto.StorageListDto;
import vn.codegym.pig_farm.entity.Storage;

public interface IStorageService {
    /**
     * Created by: HoangDT
     * Date created: 08/09/2022
     * Function: findAll
     */

    Page<StorageListDto> findAll(Pageable pageable, String keyWord);

    /**
     * Created by: HoangDT
     * Date created: 08/09/2022
     * Function: create storage
     */
    void save(Storage storage);
}

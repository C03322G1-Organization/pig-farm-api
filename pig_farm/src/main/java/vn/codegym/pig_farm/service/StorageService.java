package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.entity.Storage;

public interface StorageService {
    Page<Storage> findAll(Pageable pageable,String keyWord);

    void save(Storage storage);
}

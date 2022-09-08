package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Storage;
import vn.codegym.pig_farm.repository.StorageRepository;
import vn.codegym.pig_farm.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageRepository storageRepository;

    @Override
    public Page<Storage> findAll(Pageable pageable, String keyWord) {
        return storageRepository.findAllStorage(pageable,"%" + keyWord + "%");
    }

    @Override
    public void save(Storage storage) {
        storageRepository.saveS(storage.getAmount(), storage.getFoodType(), storage.getDate(), storage.getUnit());
    }


}

package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Advertisement;
import vn.codegym.pig_farm.repository.IAdvertisementRepository;
import vn.codegym.pig_farm.service.IAdvertisementService;

@Service
public class AdvertisementServiceImpl implements IAdvertisementService {
    @Autowired
    IAdvertisementRepository advertisementRepository;

    /**
     * @param pageable
     * @param keySearch
     * @return List Advertisement, status 200
     * @function (Query to display All Advertisement and search)
     * @creator DucNH
     * @date-create 08/09/2022
     */
    @Override
    public Page<Advertisement> findAllAdvertisement(Pageable pageable, String keySearch) {
        return advertisementRepository.findAllAdvertisement(pageable, "%" + keySearch + "%");
    }

    /**
     * @param ids
     * @function (Query to delete Advertisement)
     * @creator DucNH
     * @date-create 08/09/2022
     */
    @Override
    public void deleteAdvertisement(Integer[] ids) {
        for (Integer id : ids) {
            advertisementRepository.delete(id);
        }
    }
}

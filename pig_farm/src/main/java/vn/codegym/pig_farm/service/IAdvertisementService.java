package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.entity.Advertisement;

public interface IAdvertisementService {
    /**
     * @function (Query to display all Advertisement and search)
     * @creator DucNH
     * @date-create 08/09/2022
     * @param pageable
     * @param keySearch
     * @return List Advertisement, status 200
     */
    Page<Advertisement> findAllAdvertisement(Pageable pageable, String keySearch);

    /**
     * @function (Query to delete Advertisement)
     * @creator DucNH
     * @date-create 08/09/2022
     * @param ids
     */
    void deleteAdvertisement(Integer[] ids);
}

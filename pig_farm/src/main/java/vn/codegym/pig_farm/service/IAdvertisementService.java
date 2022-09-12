package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.projection.IAdvertisementProjection;

public interface IAdvertisementService {
    /**
     * @param pageable
     * @param keySearch
     * @return List Advertisement, status 200
     * @function (Query to display all Advertisement and search)
     * @creator DucNH
     * @date-create 08/09/2022
     */
    Page<IAdvertisementProjection> findAllAdvertisement(Pageable pageable, String keySearch);

    /**
     * @param ids
     * @function (Query to delete Advertisement)
     * @creator DucNH
     * @date-create 08/09/2022
     */
    void delete(Integer[] ids);
}

package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.entity.Advertisement;
import vn.codegym.pig_farm.projection.IAdvertisementProjection;

import javax.transaction.Transactional;

public interface IAdvertisementRepository extends JpaRepository<Advertisement, Integer> {
    /**
     * @param pageable
     * @param keySearch
     * @return Advertisement, status 200
     * @function (Query to display all Advertisement and search)
     * @creator DucNH
     * @date-create 08/09/2022
     */
    @Query(value = "select id ,title ,image ,submitted_date as submittedDate,time_existence as timeExistence, is_deleted, placement_id " +
            "from advertisement where title like :keySearch and is_deleted = 0", nativeQuery = true,
            countQuery = "select count(*) from (select id ,title ,image ,submitted_date as submittedDate,time_existence as timeExistence, is_deleted, placement_id " +
                    "from advertisement where title like :keySearch and is_deleted = 0) as abc")
    Page<IAdvertisementProjection> findAllAdvertisement(Pageable pageable, @Param("keySearch") String keySearch);

    /**
     * @param id
     * @function (Query to delete Advertisement)
     * @creator DucNH
     * @date-create 08/09/2022
     */
    @Transactional
    @Modifying
    @Query(value = "update advertisement set is_deleted = 1 where id =:id", nativeQuery = true)
    void deleteAdvertisement(@Param("id") Integer id);
}

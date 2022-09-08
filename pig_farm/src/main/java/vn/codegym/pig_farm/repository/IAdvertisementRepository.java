package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.entity.Advertisement;

public interface IAdvertisementRepository extends JpaRepository<Advertisement, Integer> {
    /**
     *  @function (Query to display all Advertisement and search)
     *  @creator DucNH
     *  @date-create 08/09/2022
     * @param pageable
     * @param keySearch
     * @return Advertisement, status 200
     */
    @Query(value = "select * from advertisement where title like :keySearch and is_deleted = 0", nativeQuery = true)
    Page<Advertisement> findAllAdvertisement(Pageable pageable, @Param("keySearch") String keySearch);

    /**
     *  @function (Query to delete Advertisement)
     *  @creator DucNH
     *  @date-create 08/09/2022
     * @param id
     */
    @Modifying
    @Query(value = "update advertisement set is_delete =1 where id =:id", nativeQuery = true)
    void delete(@Param("id") Integer id);
}

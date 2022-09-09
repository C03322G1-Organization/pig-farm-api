package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.entity.Export;
import vn.codegym.pig_farm.entity.Pigsty;

import java.time.LocalDate;

@Repository
public interface IExportRepository extends JpaRepository<Export,Integer> {

    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: createExport
     */

    @Modifying
    @Transactional
    @Query(value = "insert into `export` (pigsty_id,employee_id,code_export,company," +
            "price,type_pigs) values" +
            " (:pigstyId,:employeeId,:codeExport,:company,:price,:typePigs)",
            nativeQuery = true)
    void create(@Param("pigstyId") Integer pigstyId,
                @Param("employeeId") Integer employeeId,
                @Param("codeExport") String codeExport,
                @Param("company") String company,
                @Param("price") Double price,
                @Param("typePigs") String typePigs
    );

    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: updateExport
     */

    @Modifying
    @Transactional
    @Query(value = "update `export` set pigsty_id = :pigstyId,employee_id = :employeeId,code_export = :codeExport,company = :company," +
            "price = :price,type_pigs = :typePigs where id = :id",
            nativeQuery = true)
    void update(@Param("pigstyId") Pigsty pigstyId, @Param("employeeId") Employee employeeId,
                 @Param("codeExport") String codeExport, @Param("company") String company,
                 @Param("price") Double price,
                @Param("typePigs") String typePigs, @Param("id") Integer id
    );

    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: findById
     */
    @Query(value = "select * from export where id = :id", nativeQuery = true)
    Export findById(@Param("id") int id);

    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: findById
     * return totalWeight
     */
    @Query(value = "select sum(weight) as weighht from pig where pigsty_id = :id ;", nativeQuery = true)
    Integer totalWeight(@Param("id") int id);

    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: findById
     * return countPigOnPigsty
     */
    @Query(value = "select count(pig.pigsty_id) from pig join pigsty on pig.pigsty_id = pigsty.id where pigsty.id =:id",nativeQuery = true)
    Integer countPigOnPigsty(@Param("id") int id);

}

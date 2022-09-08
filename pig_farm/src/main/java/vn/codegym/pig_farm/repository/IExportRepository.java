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
    @Query(value = "insert into `export` (pigsty_id,employee_id,code_export,company,start_date,amount,kilogram," +
            "price,type_pigs) values" +
            " (:pigstyId,:employeeId,:codeExport,:company,:startDate,:amount,:kilogram,:price,:typePigs)",
            nativeQuery = true)
    void create(@Param("pigstyId") Pigsty pigstyId,
                @Param("employeeId") Employee employeeId,
                @Param("codeExport") String codeExport,
                @Param("company") String company,
                @Param("startDate") LocalDate startDate,
                @Param("amount") Integer amount,
                @Param("kilogram") Double kilogram,
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
            "start_date = :startDate,amount = :amount,kilogram = :kilogram,price = :price,type_pigs = :typePigs where id = :id",
            nativeQuery = true)
    void update(@Param("pigstyId") Pigsty pigstyId, @Param("employeeId") Employee employeeId,
                 @Param("codeExport") String codeExport, @Param("company") String company,
                @Param("startDate") LocalDate startDate, @Param("amount") Integer amount,
                @Param("kilogram") Double kilogram,@Param("price") Double price,
                @Param("typePigs") String typePigs, @Param("id") Integer id
    );

    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: findById
     */
    @Query(value = "select * from export where id = :id", nativeQuery = true)
    Export findById(@Param("id") int id);

}

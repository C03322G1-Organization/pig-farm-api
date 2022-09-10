package vn.codegym.pig_farm.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.pig_farm.dto.IExportDto;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.entity.Export;
import vn.codegym.pig_farm.entity.Pigsty;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ExportRepository extends JpaRepository<Export, Integer> {

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: show export pork list
     * @Param: pageable
     * @return
     */
    @Query(value = "SELECT e.id as id, " +
            "amount as amount, " +
            "e.code_export as codeExport, " +
            "company as company, " +
            "e.is_deleted as isDeleted, " +
            "kilogram as kilogram, " +
            "price as price, " +
            "e.start_date as startDate, " +
            "e.employee_id as idEmployee, emp.code as codeEmployee, emp.name as nameEmployee, " +
            "e.type_pigs as typePigs " +
            "FROM export e " +
            "RIGHT JOIN employee as emp on emp.id = e.employee_id " +
            "where e.is_deleted = 0 and code_export like:codeExport and company like:company", nativeQuery = true)
    Page<IExportDto> listAllExport(Pageable pageable, @Param("codeExport") String codeExport, @Param("company") String company);

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: delete export pork
     * @Param: id
     */
    @Modifying
    @Query(value = "UPDATE export SET is_deleted = 1 WHERE id=:id", nativeQuery = true)
    void deleteByStatus(@Param("id") Integer id);

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: find export by Id
     * @Param: id
     * @return
     */
//    @Query(value = "SELECT id, amount, code_export, company, is_deleted, kilogram," +
//            " price, start_date, employee_id, pigsty_id FROM export WHERE id=:id", nativeQuery = true)
//    Export findById(@Param("id") int id);

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

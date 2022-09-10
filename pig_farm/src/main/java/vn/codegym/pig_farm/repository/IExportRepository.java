package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.pig_farm.dto.IExportDto;
import vn.codegym.pig_farm.entity.Export;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IExportRepository extends JpaRepository<Export, Integer> {

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
    @Query(value = "SELECT id, amount, code_export, company, is_deleted, kilogram," +
            " price, start_date, employee_id, pigsty_id FROM export WHERE id=:id", nativeQuery = true)
    Export findById(@Param("id") int id);

}

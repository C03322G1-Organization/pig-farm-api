package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
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
    @Query(value = "SELECT * FROM export WHERE is_deleted = 0", nativeQuery = true)
    Page<Export> listAllExport(Pageable pageable);

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
    @Query(value = "SELECT * FROM export WHERE id=:id", nativeQuery = true)
    Export findById(@Param("id") int id);

    @Query(value = "select * from export where code_export like:codeExport || company like:company", nativeQuery = true)
    Page<Export> search(@Param("codeExport") String codeExport,@Param("company") String company, Pageable pageable);
}

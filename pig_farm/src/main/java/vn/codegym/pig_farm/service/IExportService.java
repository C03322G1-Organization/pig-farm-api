package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.dto.IExportDto;
import vn.codegym.pig_farm.entity.Export;

import java.util.List;

public interface IExportService {

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: get all export pork
     * @Param: pageable
     * @return
     */
    Page<IExportDto> listAll(Pageable pageable);

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: delete export pork
     * @Param: export
     */
    void delete(Export export);

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: find by Id
     * @Param: id
     * @return
     */
    Export findById(int id);

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: search by code export or company
     * @Param: codeExport, company, pageable
     * @return
     */
    Page<Export> searchExport(String codeExport, String company, Pageable pageable);
}

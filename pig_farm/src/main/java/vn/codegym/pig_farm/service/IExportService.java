package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.dto.ExportDto;
import vn.codegym.pig_farm.dto.IExportDto;
import vn.codegym.pig_farm.entity.Export;

public interface IExportService {

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: get all export pork
     * @Param: pageable
     * @return
     */
    Page<IExportDto> listAll(Pageable pageable, String codeExport, String company);

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: delete export pork
     * @Param: export
     */
    void delete(Export export);


    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: create
     */
    void create(ExportDto exportDto);

    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: update
     */
    void update(Export export);

    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: findById
     *
     */
    Export findById(int id);

}

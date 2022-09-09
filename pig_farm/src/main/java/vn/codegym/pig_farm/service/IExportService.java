package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.dto.ExportDto;
import vn.codegym.pig_farm.entity.Export;

public interface IExportService {

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

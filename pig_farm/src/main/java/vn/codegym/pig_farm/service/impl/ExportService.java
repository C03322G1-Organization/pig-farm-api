package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Export;
import vn.codegym.pig_farm.repository.IExportRepository;
import vn.codegym.pig_farm.service.IExportService;

@Service
public class ExportService implements IExportService {
    @Autowired
    private IExportRepository iExportRepository;

    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: create
     */
    @Override
    public void create(Export export) {
        iExportRepository.create(export.getPigsty(), export.getEmployee(), export.getCodeExport(), export.getCompany(),
                export.getStartDate(), export.getAmount(), export.getKilogram(), export.getPrice(), export.getTypePigs());
    }
    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: update
     */
    @Override
    public void update(Export export) {
        iExportRepository.update(export.getPigsty(), export.getEmployee(), export.getCodeExport(), export.getCompany(),
                export.getStartDate(), export.getAmount(), export.getKilogram(), export.getPrice(), export.getTypePigs(),
                export.getId());
    }
    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: findById
     */
    @Override
    public Export findById(int id) {
        return iExportRepository.findById(id);
    }


}

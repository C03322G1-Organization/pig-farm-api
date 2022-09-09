package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.dto.IExportDto;
import vn.codegym.pig_farm.entity.Export;
import vn.codegym.pig_farm.repository.IExportRepository;
import vn.codegym.pig_farm.service.IExportService;


@Service
public class ExportService implements IExportService {

    @Autowired
    IExportRepository iExportRepository;

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: get all export pork
     * @Param: pageable
     * @return
     */
    @Override
    public Page<IExportDto> listAll(Pageable pageable) {
        return iExportRepository.listAllExport(pageable);
    }

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: delete export pork
     * @Param: export
     */
    @Override
    public void delete(Export export) {
      iExportRepository.deleteByStatus(export.getId());
    }

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: find by Id
     * @Param: id
     * @return
     */
    @Override
    public Export findById(int id) {
        return iExportRepository.findById(id);
    }

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: search by code export or company
     * @Param: codeExport, company, pageable
     * @return
     */
    @Override
    public Page<Export> searchExport(String codeExport, String company, Pageable pageable) {
        return iExportRepository.search("%" + codeExport + "%" , "%" + company + "%", pageable);
    }
}

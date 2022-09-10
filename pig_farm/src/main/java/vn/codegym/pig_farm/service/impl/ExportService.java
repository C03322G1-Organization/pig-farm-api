package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.dto.ExportDto;
import vn.codegym.pig_farm.dto.IExportDto;
import vn.codegym.pig_farm.entity.Export;
import vn.codegym.pig_farm.repository.ExportRepository;
import vn.codegym.pig_farm.service.IExportService;

@Service
public class ExportService implements IExportService {

    @Autowired
    ExportRepository iExportRepository;

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: get all export pork
     * @Param: pageable
     * @return
     */
    @Override
    public Page<IExportDto> listAll(Pageable pageable, String codeExport, String company) {
        return iExportRepository.listAllExport(pageable, "%" + codeExport + "%", "%" + company + "%");
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
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: create
     */
    @Override
    public void create(ExportDto exportDto) {
        iExportRepository.create(exportDto.getPigstyDto().getId(),
                exportDto.getEmployeeDto().getId(),
                exportDto.getCodeExport(),
                exportDto.getCompany(),
                exportDto.getPrice(),
                exportDto.getTypePigs());
    }
    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: update
     */
    @Override
    public void update(Export export) {
        iExportRepository.update(export.getPigsty(), export.getEmployee(), export.getCodeExport(), export.getCompany(),
                 export.getPrice(), export.getTypePigs(),
                export.getId());
    }
    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: findById
>>>>>>> export-port-HoaL
     */
    @Override
    public Export findById(int id) {
        return iExportRepository.findById(id);
    }
}

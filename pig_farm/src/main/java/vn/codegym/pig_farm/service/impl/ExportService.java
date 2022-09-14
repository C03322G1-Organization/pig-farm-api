package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.dto.projections.ExportDto;
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

    public Page<ExportDto> listAll(Pageable pageable, String codeExport, String company, String nameEmployee) {
        return iExportRepository.listAllExport(pageable, "%" + codeExport + "%", "%" + company + "%" , "%" +  nameEmployee + "%");
    }

    /**
     * Create by: DongLHP
     * Date create: 08/09/2022
     * Function: delete export pork
     * @Param: export
     */
    @Override
    public void delete(Integer[] ids) {
        for (Integer id: ids) {
            iExportRepository.deleteByStatus(id);
        }
    }


    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: create
     */
    @Override
    public void create(vn.codegym.pig_farm.dto.ExportDto exportDto) {
        iExportRepository.create(exportDto.getPigstyDto().getId(),
                exportDto.getEmployeeDto().getId(),
                exportDto.getCodeExport(),
                exportDto.getCompany(),
                exportDto.getPrice(),
                exportDto.getTypePigs(),exportDto.getAmount(),exportDto.getKilogram());
    }
    /**
     * Created by: HoaL
     * Date created: 08/09/2022
     * Function: update
     */
    @Override
    public void update(vn.codegym.pig_farm.dto.ExportDto exportDto) {
        iExportRepository.update(exportDto.getPigstyDto(), exportDto.getEmployeeDto(), exportDto.getCodeExport(), exportDto.getCompany(),
                exportDto.getPrice(), exportDto.getTypePigs(),exportDto.getAmount(),exportDto.getKilogram(),
                exportDto.getId());
    }
    /**
     * Created by: DongLHP
     * Date created: 08/09/2022
     * Function: findById
     */
    @Override
    public vn.codegym.pig_farm.dto.ExportDto findById(int id) {
        return iExportRepository.findById(id);
    }


}

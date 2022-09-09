package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.dto.IVaccinationDto;
import vn.codegym.pig_farm.entity.Vaccination;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface VaccinationRepository extends JpaRepository<Vaccination, Integer> {

    /**
     * @function (Query to display all Vaccination and search)
     * @creator TamLT
     * @date-create 08/09/2022
     * @param pageable
     * @param name
     * @return List Vaccination, status 200
     */

    @Query(value = "select v.id,v.amount,v.date,v.vaccinated_person as vaccinatedPerson, vaccine_type as vaccineType ,p.code as pigstyCode" +
            " from vaccination v " +
            " join pigsty as p on v.id=p.id" +
            " where vaccinated_person like :name and v.is_deleted =0", nativeQuery = true)
    Page<IVaccinationDto> getAllVaccination(Pageable pageable, @Param("name")String name);

    @Modifying
    @Query(value = "update vaccination set is_deleted =1 where id =:id", nativeQuery = true)
    void delete(@Param("id") Integer id);

    @Query(value = "select * from vaccination where id=:id",nativeQuery = true)
    Optional<IVaccinationDto> findIdVaccination(@Param("id")Integer id);
}

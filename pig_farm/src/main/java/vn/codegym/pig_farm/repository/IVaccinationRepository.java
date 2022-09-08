package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.pig_farm.entity.Pigsty;
import vn.codegym.pig_farm.entity.Vaccination;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface IVaccinationRepository extends JpaRepository<Vaccination, Integer> {
//    @Query(value="select * from vaccination", nativeQuery=true)
//    List<Vaccination> getAll();

    @Modifying
    @Transactional
    @Query(value = "insert into vaccination(amount, `date`, is_deleted, note, vaccinated_person, vaccine_type, pigsty_id)" +
            "value(:amount, :date, :isDeleted, :note, :vaccinationPerson, :vaccineType, :pigsty)", nativeQuery=true)
    void createVaccination(@Param("amount") Integer amount,
                           @Param("date") LocalDate date,
                           @Param("isDeleted") Boolean isDeleted,
                           @Param("note") String note,
                           @Param("vaccinationPerson") String vaccinationPerson,
                           @Param("vaccineType") String vaccineType,
                           @Param("pigsty") Pigsty pigsty);
}

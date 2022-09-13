package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.pig_farm.entity.Pigsty;

import java.util.List;

@Transactional
public interface PigstyRepository extends JpaRepository<Pigsty, Integer> {
    /**
     * Created by: DatVT
     * Date created: 08/09/2022
     * Function: findByIdPigsty
     */
    @Query(value = "select * from pigsty ", nativeQuery = true)
    List<Pigsty> findALLPigsty();

}

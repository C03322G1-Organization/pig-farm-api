package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.pig_farm.entity.Placement;

public interface IPlacementRepository extends JpaRepository<Placement, Integer> {

}

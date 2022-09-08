package vn.codegym.pig_farm.dto;

import vn.codegym.pig_farm.entity.Pigsty;
import vn.codegym.pig_farm.entity.Storage;

public interface IFoodDto {
    Integer getId();
    Integer getAmount();
    String getUnit();
    String getPigsty();
    String getStorage();
    Boolean getIsDeleted();

}

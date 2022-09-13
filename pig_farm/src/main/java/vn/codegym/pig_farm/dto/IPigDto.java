package vn.codegym.pig_farm.dto;

public interface IPigDto {
    Integer getId();
    String getCode();
    String getDateIn();
    String getDateOut();
    String getStatus();
    String getWeight();
    String getPigstyCode();
    String getIsDeleted();
    String getPigsty();
}

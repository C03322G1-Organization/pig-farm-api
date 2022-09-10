package vn.codegym.pig_farm.projection;

import java.time.LocalDate;

public interface IAdvertisementProjection {

    Integer getId();

    String getTitle();

    LocalDate getSubmittedDate();

    String getTimeExistence();

    String getImage();
}

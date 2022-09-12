package vn.codegym.pig_farm.dto;

import java.time.LocalDate;

/**
 * Create by HaiTV
 * Date : 08/09/2022
 */
public interface INotificationDto {
    Integer getId();

    String getContent();

    String getImage();

    LocalDate getSubmittedDate();

}
